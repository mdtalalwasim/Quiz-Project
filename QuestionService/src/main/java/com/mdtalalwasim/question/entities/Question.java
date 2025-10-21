package com.mdtalalwasim.question.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "questions")
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String question;

    private Long quizId;

}
