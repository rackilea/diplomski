import scala.collection.JavaConversions.asScalaBuffer
import scala.reflect.runtime.universe
import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.rdd.RDD
import com.datastax.spark.connector.SomeColumns
import com.datastax.spark.connector.toNamedColumnRef
import com.datastax.spark.connector.toRDDFunctions

object JavaListInsert {
  def randomStores(sc: SparkContext, users: List[User]): RDD[(String, String, String)] = {
       sc.parallelize(users).map { x => 
       val fistName = x.getFirstName
       val lastName = x.getLastName
       val city = x.getCity
       (fistName, lastName, city)
    }
  }

  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("cassandraInsert")
    val sc = new SparkContext(conf)
    val usersList = Test.getUsers.toList
    randomStores(sc, usersList).
      saveToCassandra("test", "stores", SomeColumns("first_name", "last_name", "city"))
    sc.stop
  }
}