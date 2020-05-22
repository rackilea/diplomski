import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class MultiplicationTests {

    static Stream<Integer[]> numbersProvider() {
        return Stream.of(
                new Integer[]{1, 2, 2},
                new Integer[]{5, 3, 15},
                new Integer[]{121, 4, 484}
        );
    }

    @ParameterizedTest(name = "{0} * {1} = {2}")
    @MethodSource("numbersProvider")
    void testMultiplication(int a, int b, int expectedResult) {
        assertEquals(expectedResult, a * b);
    }

}