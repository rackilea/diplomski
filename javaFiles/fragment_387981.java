abstract class Base extends Serializable with Product

case class A(name: String) extends Base

case class B(age: Int) extends Base

object BaseEncoder {
  implicit def baseEncoder: org.apache.spark.Encoder[Base] = org.apache.spark.Encoders.kryo[Base]
}


val listA: Seq[A] = Seq(A("a"), A("b"))
val listB: Seq[B] = Seq(B(1), B(2))
val list: Seq[Base] = listA ++ listB

val ds = sc.parallelize(list).toDS