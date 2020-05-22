object Application extends Controller {

  implicit val timeout = Timeout(1 second)

  val cb = new ConfigurationBuilder()
  cb.setDebugEnabled(true)
    .setOAuthConsumerKey("")
    .setOAuthConsumerSecret("")
    .setOAuthAccessToken("")
    .setOAuthAccessTokenSecret("")

  val twitterListener = Akka.system.actorOf(TwitterListener.props(cb.build()))

  def join = WebSocket.async[JsValue] { request =>
    (twitterListener ? RequestStream()).mapTo[Connected].map {
      case Connected(stream) => (Iteratee.ignore, stream)
    }
  }
}