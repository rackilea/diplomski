import play.api.libs.json._

case class CaseClass (
           Players :Option[JsValue]
         )

object CaseClass {

  implicit val jsonFormat = Json.format[CaseClass ]
}