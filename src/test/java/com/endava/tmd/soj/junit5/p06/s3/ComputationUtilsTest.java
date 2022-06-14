package com.endava.tmd.soj.junit5.p06.s3;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.endava.tmd.soj.junit5.p06.s3.ComputationUtils.sum;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

// Provocare: Rescrieti cele doua teste parametrizate din sectiunea 1 astfel incat sa existe
// cate o metoda care sa furnizeze valorile parametrilor. Dar, nu se vor mai folosi valorile
// explicite pentru valoarea minima si maxima acceptata de Java pentru tipul de date intreg,
// ci se vor folosi Integer.MIN_VALUE, respectiv Integer.MAX_VALUE
// Se va utiliza adnotarea @MethodSource.
class ComputationUtilsTest {
    @ParameterizedTest(name = "{0} + ({1}) = {2}")
    @MethodSource("sumParameterizedArguments")
    void sumParameterized(int a,int b, int result) {
        assertThat(sum(a,b)).isEqualTo(result);
    }
    static Stream<Arguments> sumParameterizedArguments()
    {
        return Stream.of(
                Arguments.of(10,20,30),
                Arguments.of(1234,5678,6912),
                Arguments.of(-58,-22,-80),
                Arguments.of(-50,100,50)
        );
    }



    @ParameterizedTest(name = "{0} + ({1}) \u21D2 Overflow")
    @MethodSource("sumOutOfIntLimitsParameterizedArguments")
    void sumOutOfIntLimitsParameterized(int a,int b) {
        assertThatThrownBy(() -> sum(a, b))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("Overflow while computing the sum");
    }

    static Stream<Arguments> sumOutOfIntLimitsParameterizedArguments()
    {
        return Stream.of(
                Arguments.of(Integer.MAX_VALUE,10),
                Arguments.of(Integer.MAX_VALUE,Integer.MAX_VALUE),
                Arguments.of(Integer.MIN_VALUE,-22),
                Arguments.of(Integer.MIN_VALUE,Integer.MIN_VALUE)
        );
    }
}
