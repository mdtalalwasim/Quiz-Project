package com.mdtalalwasim.quiz.services.impl;

import com.mdtalalwasim.quiz.entities.Quiz;
import com.mdtalalwasim.quiz.repositories.QuizRepository;
import com.mdtalalwasim.quiz.services.QuestionClient;
import com.mdtalalwasim.quiz.services.QuizService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuizServiceImpl implements QuizService {

    private QuizRepository quizRepository;

    private QuestionClient questionClient;

    public QuizServiceImpl(QuizRepository quizRepository, QuestionClient questionClient) {
        this.quizRepository = quizRepository;
        this.questionClient = questionClient;
    }

    @Override
    public Quiz addQuiz(Quiz quiz) {
        return quizRepository.save(quiz);
    }

    //before feign client
//    @Override
//    public Quiz getQuiz(Long id) {
//        return quizRepository.findById(id).orElseThrow(()->new RuntimeException("Quiz not found for this id :: "+id));
//    }

    @Override
    public Quiz getQuiz(Long id) {
        Quiz quiz = quizRepository.findById(id).orElseThrow(() -> new RuntimeException("Quiz not found for this id :: " + id));
        quiz.setQuestions(questionClient.getQuestionOfQuiz(quiz.getId()));

        return quiz;
    }

    @Override
    public List<Quiz> getAllQuizzes() {
//        List<Quiz> quizes = quizRepository.findAll();
//        List<Quiz> newQuizList = quizes.stream().map(quiz -> {
//            quiz.setQuestions(questionClient.getQuestionOfQuiz(quiz.getId()));
//            return quiz;
//        }).collect(Collectors.toList());
        //return newQuizList;
        List<Quiz> quizes = quizRepository.findAll();
        quizes.forEach(quiz -> quiz.setQuestions(questionClient.getQuestionOfQuiz(quiz.getId())));
        return quizes;

    }
}
