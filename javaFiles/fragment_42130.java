import org.apache.spark.sql.types._
import org.apache.spark.sql._
import sqlContext.implicits._

val list = Seq((1, "topic1", Array("a", "b", "c", "b")), (2, "topic1", Array("b", "c", "r")), (3, "topic2", Array("e", "b", "c", "e")), (4, "topic2", Array("b", "c", "e", "r")))
val df = sc.parallelize(list).toDF("id", "topic", "entities");