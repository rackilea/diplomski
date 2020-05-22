@ParameterizedTest
@MethodSource("generator")
void testCalculateMandateI(Mandator value, boolean expected)

// and then somewhere in this test class  
private static Stream<Arguments> generator() {

 return Stream.of(
   Arguments.of(new Mandator(..), true),
   Arguments.of(new Mandator(..), false));
}