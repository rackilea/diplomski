import play.api.libs.Files._
import play.api.mvc.MultipartFormData._

class MyTestSpec extends Specification {

    "mytest should bla bla bla" in {
        running(FakeApplication(aditionalConfiguration = inMemoryDatabase())) {
            val data = new MultipartFormData(Map(
                ("param1" -> Seq("test-1")),
                ("param2" -> Seq("test-2"))
            ), List(
                FilePart("payload", "message", Some("Content-Type: multipart/form-data"), play.api.libs.Files.TemporaryFile(new java.io.File("/tmp/pepe.txt")))
    ), List(), List())

            val Some(result) = routeAndCall(FakeRequest(POST, "/route/action", FakeHeaders(), data))
            ...
        }
    }
}