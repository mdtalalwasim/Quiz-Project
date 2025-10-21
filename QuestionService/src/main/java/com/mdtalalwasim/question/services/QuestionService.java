package com.mdtalalwasim.question.services;

import com.mdtalalwasim.question.entities.Question;

import java.util.List;

public interface QuestionService {

    //create Question
    Question createQuestion(Question question);
    Question getQuestionById(Long id);
    List<Question> getAllQuestions();

    List<Question> getQuestionsByQuizId(Long quizId);

}
