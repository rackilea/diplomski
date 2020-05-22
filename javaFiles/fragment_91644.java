@ParameterizedTest
@ValueSource(ints = { 79, 80, 81 })
public void so(int argument)
{
   assertTrue((argument < 80) == someMethod(argument));
}