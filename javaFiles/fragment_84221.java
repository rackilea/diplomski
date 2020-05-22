object original {
  def needNumeric[T](value: T)(implicit n: Numeric[T]) = {
    // do something
  }
}

object NeedNumeric {
  def needNumeric(value: Int) = original.needNumeric(value)
  def needNumeric(value: Long) = original.needNumeric(value)
  def needNumeric(value: Float) = original.needNumeric(value)
  def needNumeric(value: Double) = original.needNumeric(value)
  def needNumeric(value: BigInt) = original.needNumeric(value)
  ...
}

import NeedNumeric._