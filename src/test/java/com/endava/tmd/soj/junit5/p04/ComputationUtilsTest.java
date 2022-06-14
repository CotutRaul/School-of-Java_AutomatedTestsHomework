package com.endava.tmd.soj.junit5.p04;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.endava.tmd.soj.junit5.p04.ComputationUtils.sum;
import static org.assertj.core.api.Assertions.assertThat;

// Provocare: Copiati metodele de test din tema de la p02, si adaugati ceea ce lipseste astfel incat
// sa fie testate si scenariile urmatoare. La ultima metoda, in cazul in care testul nu trece,
// adaugati adnotarea necesara astfel incat sa apara ca si "skipped"
class ComputationUtilsTest {

    @Test
    @DisplayName("0 + 0 = 0")
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
    void zeroShouldNotChangePositive() {
        assertThat(sum(0,2)).isEqualTo(2);
    }

    @Test
    @DisplayName("0 + -5 = -5")
    void zeroShouldNotChangeNegative() {
        assertThat(sum(0,-5)).isEqualTo(-5);
    }

    @Test
    @DisplayName("5 + 6 = 11")
    void twoPositiveNumbersShouldHaveAbsoluteValuesAddedAndPositiveResult() {
        assertThat(sum(5,6)).isEqualTo(11);
    }

    @Test
    @DisplayName("-5 + -11 = -16")
    void twoNegativeNumbersShouldHaveAbsoluteValuesAddedAndNegativeResult() {
        assertThat(sum(-5,-11)).isEqualTo(-16);
    }

    @Test
    @DisplayName("-5 + 11 = 6")
    void oneSmallNegativeAndOneBigPositiveNumberShouldHaveAbsoluteValuesSubtractedAndPositiveResult() {
        assertThat(sum(-5,11)).isEqualTo(6);
    }

    @Test
    @DisplayName("-111 + 31 = -80")
    void oneBigNegativeAndOneSmallPositiveNumberShouldHaveAbsoluteValuesSubtractedAndNegativeResult() {
        assertThat(sum(-111,31)).isEqualTo(-80);
    }

    @Test
    void zeroShouldNotChangeMaxInt() {
        assertThat(sum(Integer.MAX_VALUE,0)).isEqualTo(Integer.MAX_VALUE);
    }

    @Test
    void maxIntAndANegativeNumber() {
        assertThat(sum(Integer.MAX_VALUE,-100)).isEqualTo(2147483547);
    }

    @Test
    void zeroShouldNotChangeMinInt() {
        assertThat(sum(Integer.MIN_VALUE,0)).isEqualTo(Integer.MIN_VALUE);
    }

    @Test
    void minIntAndAPositiveNumber() {
        assertThat(sum(Integer.MIN_VALUE,100)).isEqualTo(-2147483548);
    }

    @Test
    void minIntAndMaxInt() {
        assertThat(sum(Integer.MIN_VALUE,Integer.MAX_VALUE)).isEqualTo(-1);
    }

    @Test
    @Disabled
    void whatToDoWhenSumExceedsMaxIntegerValue() {
        assertThat(sum(Integer.MAX_VALUE,3)).isEqualTo(2147483650L);
    }

}
