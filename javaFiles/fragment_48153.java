sealed trait Example

object Example {
  def apply[T <: AnyRef](t:T, aListOfTheseThings: List[T]): Example = 
    new ExampleImpl(t, aListOfTheseThings)

  private class ExampleImpl(
    val value: AnyRef, 
    val aListOfTheseThings: List[_]) extends Example 
}