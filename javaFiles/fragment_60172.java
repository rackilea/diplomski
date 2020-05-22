import org.apache.spark.mllib.linalg.distributed.{CoordinateMatrix,
  MatrixEntry}

val entries = sc.parallelize(Seq(
   (0, 0, 3.0), (2, 0, -5.0), (3, 2, 1.0),
   (4, 1, 6.0), (6, 2, 2.0), (8, 1, 4.0))
).map{case (i, j, v) => MatrixEntry(i, j, v)}

val coordinateMatrix = new CoordinateMatrix(entries, 9, 3)