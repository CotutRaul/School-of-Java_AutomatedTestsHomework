package com.endava.tmd.soj.junit5.p07;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

import java.text.NumberFormat;
import java.util.Locale;

// Provocare: definiti cel putin 3 teste pentru clasa care tine scorul
// Unde e cel mai potrivit ca sa initializam variabila "score"?
//
// Pentru un raspuns corect si doua incorecte, cat ar trebui sa fie scorul: 33.3 sau 33,3 ?
// 
// Daca avem colegi pe proiect care sunt din diferite parti ale lumii,
// cum putem scrie testul astfel incat sa functioneze pentru toti, indiferent de ce Locale are fiecare? 
class ScoreTest {
    private Score score;
    private static NumberFormat nf;

    @BeforeAll
    static void setupLocale()
    {
//        Locale.setDefault(Locale.US);
        Locale.setDefault(Locale.FRANCE);
        nf = NumberFormat.getInstance(Locale.getDefault());
        nf.setMinimumFractionDigits(1);
    }

    @BeforeEach
    void setupScore()
    {
        score = new Score();
    }

    @Test
    void noAnswer()
    {
        assertThat( score.getPercent()).isEqualTo(nf.format(100.0));
    }

    @Test
    void allCorrect()
    {
        score.addCorrectAnswer();
        assertThat( score.getPercent()).isEqualTo(nf.format(100.0));
    }

    @Test
    void allIncorrect()
    {
        score.addIncorrectAnswer();
        assertThat( score.getPercent()).isEqualTo(nf.format(0.0));
    }

    @Test
    void oneCorrectTwoIncorrect()
    {
        score.addCorrectAnswer();
        score.addIncorrectAnswer();
        score.addIncorrectAnswer();
        assertThat( score.getPercent()).isEqualTo(nf.format(33.3));

    }

    @Test
    void TwoCorrectTwoIncorrect()
    {
        score.addCorrectAnswer();
        score.addCorrectAnswer();
        score.addIncorrectAnswer();
        score.addIncorrectAnswer();
        assertThat( score.getPercent()).isEqualTo(nf.format(50.0));
    }

}
