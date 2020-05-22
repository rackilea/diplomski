import play.api.libs.json._

val components = input.split("\\.")

components.headOption match {
  case Some(p) => components.tail.foldLeft(JsPath \ p) { _ \ _ }
  case _ => /* cannot parse */ ???
}