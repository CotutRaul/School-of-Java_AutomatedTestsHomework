package com.endava.tmd.soj.junit5.p03.s2;

import org.junit.jupiter.api.*;

import static com.endava.tmd.soj.junit5.p03.s2.ComputationUtils.sum;
import static org.assertj.core.api.Assertions.assertThat;

// Provocare: Copiati metodele de test din tema anterioara (p02), si adaugati adnotarile necesare astfel incat
// sa fie rulate testele in functie de adnotarea de ordine specificata pe fiecare metoda de test. Adnotarea de ordine
// trebuie sa fie pusa pe fiecare metoda de test astfel incat metodele sa fie executate in ordinea in care sunt scrise
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ComputationUtilsTest {
    @Test
    @DisplayName("0 + 0 = 0")
    @Order(1)
    void zeroShouldNotChangeZero() {
        //JUnit Assertion
        Assertions.assertEquals(0, sum(0, 0));


        // AssertJ Assertion
        assertThat(sum(0, 0)).isZero();

        //failed
        //Assertions.assertEquals(0,sum(5,4));

    }

    @Test
    @DisplayName("0 + 2 = 2")
    @Order(2)
    void zeroShouldNotChangePositive() {
        assertThat(sum(0,2)).isEqualTo(2);
    }

    @Test
    @DisplayName("0 + -5 = -5")
    @Order(3)
    void zeroShouldNotChangeNegative() {
        assertThat(sum(0,-5)).isEqualTo(-5);
    }

    @Test
    @DisplayName("5 + 6 = 11")
    @Order(4)
    void twoPositiveNumbersShouldHaveAbsoluteValuesAddedAndPositiveResult() {
        assertThat(sum(5,6)).isEqualTo(11);
    }

    @Test
    @DisplayName("-5 + -11 = -16")
    @Order(5)
    void twoNegativeNumbersShouldHaveAbsoluteValuesAddedAndNegativeResult() {
        assertThat(sum(-5,-11)).isEqualTo(-16);
    }

    @Test
    @DisplayName("-5 + 11 = 6")
    @Order(6)
    void oneSmallNegativeAndOneBigPositiveNumberShouldHaveAbsoluteValuesSubtractedAndPositiveResult() {
        assertThat(sum(-5,11)).isEqualTo(6);
    }

    @Test
    @DisplayName("-111 + 31 = -80")
    @Order(7)
    void oneBigNegativeAndOneSmallPositiveNumberShouldHaveAbsoluteValuesSubtractedAndNegativeResult() {
        assertThat(sum(-111,31)).isEqualTo(-80);
    }
}

