import org.apache.spark.sql.expressions.Aggregator
import org.apache.spark.sql.catalyst.encoders.ExpressionEncoder
import org.apache.spark.sql.{Encoder, Encoders}
import scala.collection.mutable.{Set => MSet}


class MergeSets[T, U](f: T => Seq[U])(implicit enc: Encoder[Seq[U]]) extends 
     Aggregator[T, MSet[U], Seq[U]] with Serializable {

  def zero = MSet.empty[U]

  def reduce(acc: MSet[U], x: T) = {
    for { v <- f(x) } acc.add(v)
    acc
  }

  def merge(acc1: MSet[U], acc2: MSet[U]) = {
    acc1 ++= acc2
  }

  def finish(acc: MSet[U]) = acc.toSeq
  def bufferEncoder: Encoder[MSet[U]] = Encoders.kryo[MSet[U]]
  def outputEncoder: Encoder[Seq[U]] = enc

}