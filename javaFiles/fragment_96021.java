import org.apache.spark.{SparkContext, SparkConf}
import java.util

case class Foo(val a: Int, val b: util.ArrayList[Int])

val conf = new SparkConf().setMaster("local").setAppName("example")
val sc = new SparkContext(conf)

val arr = new util.ArrayList[Int]()
arr.add(1)

val par = sc.parallelize[Foo](List(Foo(1, arr), Foo(2, arr), Foo(2, arr), Foo(3, arr), Foo(3, arr)))