import java.time.LocalDateTime

import akka.NotUsed
import akka.actor.ActorSystem
import akka.stream.ActorMaterializer
import akka.stream.scaladsl.Source

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._

object Application extends App {

  implicit val sys: ActorSystem = ActorSystem()
  implicit val mat: ActorMaterializer = ActorMaterializer()

  case class SomeEntity(time: Int, value: Int)

  val source: Source[SomeEntity, NotUsed] = Source(List(100, 200, 400, 1000, 1100, 1400, 1400, 1500, 1900, 2500, 2700)).map(i => SomeEntity(i, i * i + 3))


  val future = source.throttle(cost = 1, per = 1.millisecond, _.time).runForeach(se => {
    println(s"${LocalDateTime.now()} -> $se")
  })

  future.onComplete(_ => sys.terminate())
}