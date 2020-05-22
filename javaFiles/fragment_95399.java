import java.text.SimpleDateFormat
import java.util.Date
import scala.util.Try
import scala.util.{Failure, Success}

val format = new SimpleDateFormat("yyyy-MM-dd")

def strTodate(stringDate: String): Either[String, Date] = {
  Try {
    format.parse(stringDate)
  } match {
    case Success(s) => Right(s)
    case Failure(e: ParseException) => Left(s"bad format: $stringDate")
    case Failure(e: Throwable) => Left(s"Unknown error formatting : $stringDate")
  }
}

val date1 = strTodate("2018-09-26")
println(date1) // Right(Wed Sep 26 00:00:00 PDT 2018)

val date2 = strTodate("2018/09/26")
println(date2) // Left(bad format: 2018/09/26)