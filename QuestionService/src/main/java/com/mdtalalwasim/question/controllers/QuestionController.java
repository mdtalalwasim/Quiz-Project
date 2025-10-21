package com.mdtalalwasim.question.controllers;

import com.mdtalalwasim.question.entities.Question;
import com.mdtalalwasim.question.services.QuestionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/question")
public class QuestionController {
//hello
    private QuestionService questionService;
    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }


    //create Question
    @PostMapping
    public Question createQuestion(@RequestBody Question question){
        return questionService.createQuestion(question);
    }

    //get Question
    @GetMapping("{id}")
    public Question getOneQuestion(@PathVariable Long id){
        return questionService.getQuestionById(id);
    }

    @GetMapping
    public List<Question> getAllQuestions(){
        return questionService.getAllQuestions();
    }

    //getAllQuestion of specific quiz id
    @GetMapping("/quiz/{quizId}")
    public List<Question> getQuestionsByQuizId(@PathVariable Long quizId){
        return questionService.getQuestionsByQuizId(quizId);
    }



}
