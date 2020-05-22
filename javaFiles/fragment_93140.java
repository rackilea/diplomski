scala> val oneInt: java.lang.Integer = 1
oneInt: Integer = 1

scala> val nullInt: java.lang.Integer = null
nullInt: Integer = null

scala> val oneOpt: Option[Int] = Option(oneInt).map {_.toInt}
oneOpt: Option[Int] = Some(1)

scala> val nullOpt: Option[Int] = Option(nullInt).map {_.toInt}
nullOpt: Option[Int] = None