import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.model.{HttpRequest, HttpResponse}
import akka.stream.scaladsl.{Keep, Sink, Source}
import akka.stream.{ActorMaterializer, OverflowStrategy}

import scala.concurrent.duration._
import scala.concurrent.{Await, Future, Promise}
import scala.util.{Failure, Success}

import scala.concurrent.ExecutionContext.Implicits.global

implicit val system = ActorSystem("main")
implicit val materializer = ActorMaterializer()
val pool = Http().cachedHostConnectionPool[Promise[HttpResponse]](host = "google.com", port = 80)
val queue = Source.queue[(HttpRequest, Promise[HttpResponse])](10, OverflowStrategy.dropNew)
  .via(pool)
  .toMat(Sink.foreach({
    case ((Success(resp), p)) => p.success(resp)
    case ((Failure(e), p)) => p.failure(e)
  }))(Keep.left)
  .run
val promise = Promise[HttpResponse]
val request = HttpRequest(uri = "/") -> promise

val response = queue.offer(request).flatMap(buffered => {
  if (buffered) promise.future
  else Future.failed(new RuntimeException())
})

Await.ready(response, 3 seconds)