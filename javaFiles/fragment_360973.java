trait SNumberField[T <: Number] extends SAnyField[T] {
  // [...]
  def equal(value : Number)        : Condition;
  def equal(value : Field[Number]) : Condition;
}

abstract class NumberFieldBase[T <: Number](override val underlying: Field[T])
    extends AnyFieldBase[T] (underlying)
    with SNumberField[T] {

  // [...]
  def equal(value : Number)
    = underlying.equal(underlying.getDataType().convert(value));
  def equal(value : Field[_ <: Number]) 
    = underlying.equal(value.coerce(underlying.getDataType());
}