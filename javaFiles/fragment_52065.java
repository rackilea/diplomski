import play.api.libs.json._


case class Message(toID: Seq[String], fromID: String, userID: String, mailContent: String)

object Message {
  implicit val writes: Writes[Message] = Json.writes[Message]
}