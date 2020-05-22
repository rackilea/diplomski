case class Tuple4[+T1, +T2, +T3, +T4](_1: T1, _2: T2, _3: T3, _4: T4)
  extends Product4[T1, T2, T3, T4]
{
  override def toString() = "(" + _1 + "," + _2 + "," + _3 + "," + _4 + ")"

}