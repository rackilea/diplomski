import java.util.Collections
import javax.cache.CacheManager
import somewhere.CacheHelper

object QueryGenerator extends ServerResource {
  private val log = Logger.getLogger(classOf[QueryGenerator].getName)
}

class QueryGenerator extends ServerResource {

  @Get("html")
  def getHtml(): Representation = {
    val cf = CacheManager.getInstance().getCacheFactory()
    val cache = cf.createCache(Collections.emptyMap())

    val counter = if (cache.containsKey("counter")) {
      cache.get("counter").asInstanceOf[Int]
    } else {
      0
    }

    CacheHelper.update(cache,"counter",counter+1)

    val q = QueueFactory.getQueue("query-generator")
    q.add(TaskOptions.Builder.url("/tasks/query-generator").method(Method.GET).countdownMillis(1000L))

    QueryGenerator.log.warning(counter.toString())

    new StringRepresentation("QueryGenerator started!", MediaType.TEXT_HTML)
  }
}