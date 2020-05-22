@ParameterizedTest
@MethodSource("arguments")
void test(Request input, BigDecimal result) {
 // ...
}

public static Stream<Arguments> arguments() {
    r1 = Request.builder().build(); // add request configuration here
    r2 = Request.builder().build(); // ... and here
    return Stream.of(
       Arguments.of(r1, new BigDecimal("720")),
       Arguments.of(r2, null)
    );
}