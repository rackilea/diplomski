val DateMatch = """(\d\d\d\d)[-/ ]?((?:\d\d)|(?:\w\w\w))?[-/ ]?(\d\d)?T?(\d\d)?:?(\d\d)?:?(\d\d)?[\.]*(\d+)?(.*)?""".r

date match {
  case DateMatch(year, month, day, hour, min, sec, usec, timezone) =>
    (year, Option(month).getOrElse("1"), Option(day).getOrElse(1), Option(hour).getOrElse(0), Option(min).getOrElse(0), Option(sec).getOrElse(0), Option(usec).getOrElse(0), Option(timezone).getOrElse(""))
  case _ =>
    throw InvalidDateException
}