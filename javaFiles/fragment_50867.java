import java.time.LocalDateTime
import java.util.concurrent.Executors

import akka.NotUsed
import akka.actor.ActorSystem
import akka.pattern.after
import akka.stream.ActorMaterializer
import akka.stream.scaladsl.Source

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._
import scala.concurrent.{ExecutionContext, Future}

object Application extends App {

  implicit val sys: ActorSystem = ActorSystem()
  implicit val mat: ActorMaterializer = ActorMaterializer()

  case class SomeEntity(time: Int, value: Int)
  val source: Source[SomeEntity, NotUsed] = Source(List(100, 200, 400, 1000, 1100, 1400)).map(i => SomeEntity(i, i * i + 3))

  val ec: ExecutionContext = ExecutionContext.fromExecutor(Executors.newFixedThreadPool(10))
  val scheduler = sys.scheduler

  val f = source
    .mapAsync(10)(se => after(se.time.milliseconds, scheduler)(Future.successful(se))(ec))
    .runForeach(se => println(s"${LocalDateTime.now()} -> $se"))

  f.onComplete(_ => sys.terminate())
}