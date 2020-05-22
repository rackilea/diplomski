import scala.util.Try

def createSampleRequest(message: String): Option[SampleRequest] = {
  val sampleRequest = new SampleRequest()      
  Try(sampleRequest.fromString(fix, null, true))
    .map(s => Option(sampleRequest))
    .getOrElse(None)
}