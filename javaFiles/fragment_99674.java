import org.apache.spark.api.java.function.FlatMapFunction
import collection.JavaConverters._

class CustomInputMapperWKT extends FlatMapFunction[String, Any] {
  override def call(t: String): java.util.Iterator[Any] = {
    ...
    result.iterator.asJava
  }
}