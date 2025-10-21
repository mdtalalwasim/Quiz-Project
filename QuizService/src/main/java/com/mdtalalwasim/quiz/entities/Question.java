package com.mdtalalwasim.quiz.entities;

import jakarta.persistence.*;
import lombok.*;


@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Question {
    private Long id;
    private String question;
    private Long quizId;
}
