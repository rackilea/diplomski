import scala.util.{Try, Success, Failure}

def retry[T](times: Int)(block: => T): T = Try(block) match {
  case Success(result) => result
  case Failure(e) =>
    if (times > 0) {
      logger.warn(s"method failed with an exception, retry #$times")
      logger.warn(exception)
      retry(times - 1)(block)
    }
    else throw e
}