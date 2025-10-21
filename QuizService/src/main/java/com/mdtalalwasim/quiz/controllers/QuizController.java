package com.mdtalalwasim.quiz.controllers;

import com.mdtalalwasim.quiz.entities.Quiz;
import com.mdtalalwasim.quiz.services.QuizService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/quiz")
public class QuizController {



    private QuizService quizService;
    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }


    //create
    @PostMapping
    public Quiz addQuiz(@RequestBody Quiz quiz){
        return quizService.addQuiz(quiz);
    }

    //getQuiz
    @GetMapping("/{id}")
    public Quiz getQuizById(@PathVariable Long id){
        return quizService.getQuiz(id);
    }

    //get Quiz List
    @GetMapping
    public List<Quiz> getAllQuizzes(){
        return quizService.getAllQuizzes();
    }

}
