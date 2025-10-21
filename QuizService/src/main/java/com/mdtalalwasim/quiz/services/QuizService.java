package com.mdtalalwasim.quiz.services;

import com.mdtalalwasim.quiz.entities.Quiz;

import java.util.List;

public interface QuizService {
    Quiz addQuiz(Quiz quiz);
    Quiz getQuiz(Long id);
    List<Quiz> getAllQuizzes();
}
