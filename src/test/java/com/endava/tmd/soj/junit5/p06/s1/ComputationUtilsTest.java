package com.endava.tmd.soj.junit5.p06.s1;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static com.endava.tmd.soj.junit5.p06.s1.ComputationUtils.sum;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

// Provocare: Rescrieti scenariile de testare din tema precedenta folosind teste parametrizate.
// Se vor utiliza adnotarile @ParameterizedTest si @CsvSource
// E suficient sa scrieti 2 teste distincte:
// - Un test care verifica valoarea sumei a doua numere
// - Un test care verifica exceptiile generate
//
// Bonus: personalizarea numelui afisat al testului
//   * vom folosi {0} pentru a folosi valoarea primului parametru al metodei
//   * vom folosi {1} pentru a folosi valoarea celui de-al doilea parametru al metodei
//   * ...
//   dar NU in @DisplayName ci in atributul "name" al adnotarii @ParameterizedTest


class ComputationUtilsTest {

    @ParameterizedTest(name = "{0} + ({1}) = {2}")
    @CsvSource({"10,20,30","1234,5678,6912","-58,-22,-80","-50,100,50"})
    void sumParameterized(int a,int b, int result) {
        assertThat(sum(a,b)).isEqualTo(result);
    }

    @ParameterizedTest(name = "{0} + ({1}) \u21D2 Overflow")
    @CsvSource({"2147483647,10","2147483647,2147483647","-2147483648,-19","-2147483648,-2147483648"})
    void sumOutOfIntLimitsParameterized(int a,int b) {
        assertThatThrownBy(() -> sum(a, b))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("Overflow while computing the sum");
    }


}
