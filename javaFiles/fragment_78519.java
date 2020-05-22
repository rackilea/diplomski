object TwitterListener {
  case class RequestStream()
  case class Connected(numerator: Enumerator[JsValue])
  def props(conf: Configuration) = Props(new TwitterListener(conf))
}

/**
 * Twitter Stream Listener
 *
 * @param config Twitter4j Configuration
 */
class TwitterListener(config: Configuration) extends Actor {

  import TwitterListener._

  val listener = new StatusListener() {

    val (enum, channel) = Concurrent.broadcast[JsValue]

    def onStatus(status: Status) {
      channel.push(Json.obj(
        "msg" -> status.getText,
        "user" -> status.getUser.getName,
        "timestamp" -> DateTime.now.toString("yyyy-MM-dd HH:mm:ss")
      ))
    }

    def onDeletionNotice(statusDeletionNotice: StatusDeletionNotice) {

    }

    def onTrackLimitationNotice(numberOfLimitedStatuses: Int) {

    }

    def onException(ex: Exception) {
      ex.printStackTrace()
    }

    def onScrubGeo(userId: Long, upToStatusId: Long) = {

    }

    def onStallWarning(warning: StallWarning) = {

    }
  }

  override def preStart() = {
    val query = new FilterQuery(0, Array(), Array("birthday"))
    val twitterStream = new TwitterStreamFactory(config).getInstance
    twitterStream.addListener(listener)
    twitterStream.filter(query)
  }


  def receive = {
    case RequestStream() => sender ! Connected(listener.enum)
  }

}