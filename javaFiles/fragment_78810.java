object Monoid {
  implicit object StringMonoid extends Monoid[String] {
    def mzero = ""
    def madd(first: String, second: String) = first + second
  }

  implicit def NumericMonoid[T](implicit ev: Numeric[T]): Monoid[T] = 
    new Monoid[T] {
      import Numeric.Implicits._

      def mzero = ev.zero
      def madd(first: T, second: T) = first + second
    }
}