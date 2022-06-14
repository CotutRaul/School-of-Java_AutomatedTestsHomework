package com.endava.tmd.soj.junit5.p03.s1;

import org.junit.jupiter.api.*;

import static com.endava.tmd.soj.junit5.p03.s1.ComputationUtils.sum;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;


// Provocare: Copiati metodele de test din tema anterioara, si adaugati adnotarile necesare astfel incat
// sa fie rulate testele in ordine alfabetica. Modificati numele metodelor de test astfel incat metodele
// sa fie executate in ordinea in care sunt scrise

@TestMethodOrder(MethodOrderer.MethodName.class)
class ComputationUtilsTest {
    @Test
    @DisplayName("0 + 0 = 0")
    void testAZeroShouldNotChangeZero() {
        //JUnit Assertion
        Assertions.assertEquals(0, sum(0, 0));


        // AssertJ Assertion
        assertThat(sum(0, 0)).isZero();

        //failed
        //Assertions.assertEquals(0,sum(5,4));

    }

    @Test
    @DisplayName("0 + 2 = 2")
    void testBZeroShouldNotChangePositive() {
        assertThat(sum(0,2)).isEqualTo(2);
    }

    @Test
    @DisplayName("0 + -5 = -5")
    void testCZeroShouldNotChangeNegative() {
        assertThat(sum(0,-5)).isEqualTo(-5);
    }

    @Test
    @DisplayName("5 + 6 = 11")
    void testDTwoPositiveNumbersShouldHaveAbsoluteValuesAddedAndPositiveResult() {
        assertThat(sum(5,6)).isEqualTo(11);
    }

    @Test
    @DisplayName("-5 + -11 = -16")
    void testETwoNegativeNumbersShouldHaveAbsoluteValuesAddedAndNegativeResult() {
        assertThat(sum(-5,-11)).isEqualTo(-16);
    }

    @Test
    @DisplayName("-5 + 11 = 6")
    void testFOneSmallNegativeAndOneBigPositiveNumberShouldHaveAbsoluteValuesSubtractedAndPositiveResult() {
        assertThat(sum(-5,11)).isEqualTo(6);
    }

    @Test
    @DisplayName("-111 + 31 = -80")
    void testGOneBigNegativeAndOneSmallPositiveNumberShouldHaveAbsoluteValuesSubtractedAndNegativeResult() {
        assertThat(sum(-111,31)).isEqualTo(-80);
    }
}
