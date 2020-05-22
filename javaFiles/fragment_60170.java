import org.apache.spark.mllib.linalg.{Vectors, Matrices}
import org.apache.spark.mllib.linalg.distributed.{IndexedRowMatrix,
  IndexedRow}

val rows =  sc.parallelize(Seq(
  (0L, Array(1.0, 0.0, 0.0)),
  (0L, Array(0.0, 1.0, 0.0)),
  (0L, Array(0.0, 0.0, 1.0)))
).map{case (i, xs) => IndexedRow(i, Vectors.dense(xs))}

val indexedRowMatrix = new IndexedRowMatrix(rows)