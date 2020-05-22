@ParameterizedTest
@MethodSource("args")
public void so(int argument)
{
   assertTrue((argument < 80) == someMethod(argument));
}

private static IntStream args()
{
   return IntStream.range(0, 100);
}