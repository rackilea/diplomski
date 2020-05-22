package util

object Binders {

  implicit object DoubleQueryBindable extends QueryStringBindable[Double] {
    def bind(key: String, params: Map[String, Seq[String]]) = params.get(key).flatMap(_.headOption).map { value =>
      try {
        Right(value.toDouble)
      } catch {
        case e: Exception =>  Left("Cannot parse parameter " + key + " as Double")
      }
    }
    def unbind(key: String, value: Double) = key + "=" + value.toString
  }

  implicit object DoublePathBindable extends PathBindable[Double] {
    def bind(key: String, value: String) = try {
      Right(value.toDouble)
    } catch {
      case e: Exception => Left("Cannot parse parameter '" + key + "' as Double")
    }

    def unbind(key: String, value: Double): String = value.toString
  }
}