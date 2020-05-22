import org.apache.kafka.streams.kstream._
import org.apache.kafka.common.serialization._
import org.apache.kafka.streams.KeyValue


object Q49594920 {

      val creducer: Reducer[java.lang.Long] =
      (v1, v2) => if (v1 > v2) v1 else v2

    val deduplicationWindow = TimeWindows
      .of(60000L * 10)
      .advanceBy(60000L)
      .until(60000L * 10)

    val ktwindow: KTable[Windowed[String], java.lang.Long] = ???
      // ipandTime // What's that? It's not defined anywhere!
      //   .groupByKey(Serdes.String(), Serdes.Long())
      //   .reduce(creducer, deduplicationWindow, "ktwindow-query")

    val fStream = ktwindow
      .toStream()
      .selectKey[KeyValue[String, java.lang.Long]](
        new KeyValueMapper[Windowed[String],
                           java.lang.Long,
                           KeyValue[String, java.lang.Long]] {
          override def apply(
              key: Windowed[String],
              value: java.lang.Long): KeyValue[String, java.lang.Long] = {
            new KeyValue(key.key(), value)
          }
        }
      )
}