val myVertices: RDD[(VertexId, String)] = sc.makeRDD(Array((1L, "A"), (2L, "B"), (3L, "C"), (4L, "D"), (5L, "E"), (6L, "F"), (7L, "G")))
val myEdges: RDD[Edge[Double]] = sc.makeRDD(Array(Edge(1L, 2L, 7.0), Edge(1L, 4L, 5.0), Edge(2L, 3L, 8.0), Edge(2L, 4L, 9.0), Edge(2L, 5L, 7.0), Edge(3L, 5L, 5.0), Edge(4L, 5L, 15.0), Edge(4L, 6L, 6.0),Edge(5L, 6L, 8.0), Edge(5L, 7L, 9.0), Edge(6L, 7L, 11.0)))

val my_graph = Graph(myVertices, myEdges).cache()

val v1 = 4000000028222916L

val results = dijkstra(my_graph, 1L).vertices.map(_._2).collect

// [CTRL-D]
// Exiting paste mode, now interpreting.
// [Lscala.Tuple2;@668a0785                                                        
// import org.apache.spark.graphx._
// myVertices: org.apache.spark.rdd.RDD[(org.apache.spark.graphx.VertexId, String)] = ParallelCollectionRDD[556] at makeRDD at <console>:37
// myEdges: org.apache.spark.rdd.RDD[org.apache.spark.graphx.Edge[Double]] = ParallelCollectionRDD[557] at makeRDD at <console>:39
// my_graph: org.apache.spark.graphx.Graph[String,Double] = org.apache.spark.graphx.impl.GraphImpl@49ea0d90
// dijkstra: [VD](g: org.apache.spark.graphx.Graph[VD,Double], origin: org.apache.spark.graphx.VertexId)org.apache.spark.graphx.Graph[(VD, List[Any]),Double]
// v1: Long = 4000000028222916
// results: Array[(String, List[Any])] = Array((A,List(0.0, List())), (B,List(7.0, List(1))), (C,List(15.0, Li...
scala> results.foreach(println)
// (A,List(0.0, List()))
// (B,List(7.0, List(1)))
// (C,List(15.0, List(1, 2)))
// (D,List(5.0, List(1)))
// (E,List(14.0, List(1, 2)))
// (F,List(11.0, List(1, 4)))
// (G,List(22.0, List(1, 4, 6)))