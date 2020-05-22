scala> import org.apache.spark.mllib.linalg.{Vectors, Vector}
import org.apache.spark.mllib.linalg.{Vectors, Vector}

scala> import org.apache.spark.mllib.linalg.distributed.RowMatrix
import org.apache.spark.mllib.linalg.distributed.RowMatrix

scala> val matVec = Vector(Vectors.dense(5,0,5), Vectors.dense(0,10,0), Vectors.dense(5,0,5))
matVec: scala.collection.immutable.Vector[org.apache.spark.mllib.linalg.Vector] = Vector([5.0,0.0,5.0], [0.0,10.0,0.0], [5.0,0.0,5.0])

scala> val matRDD = sc.parallelize(matVec)
matRDD: org.apache.spark.rdd.RDD[org.apache.spark.mllib.linalg.Vector] = ParallelCollectionRDD[44] at parallelize at <console>:37

scala> val myRowMat = new RowMatrix(matRDD)
myRowMat: org.apache.spark.mllib.linalg.distributed.RowMatrix = org.apache.spark.mllib.linalg.distributed.RowMatrix@7a7a07c2

scala> myRowMat.columnSimilarities.entries.collect.foreach{println}
MatrixEntry(0,2,0.9999999999999998)