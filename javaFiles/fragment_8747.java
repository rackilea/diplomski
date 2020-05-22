val g = PartialFlowGraph { implicit b =>
  import FlowGraphImplicits._
  val in1 = actorSource1
  val in2 = actorSource2
  // etc.

  val out = UndefinedSink[T]
  val merge = Merge[T]

  in1 ~> merge ~> out
  in2 ~> merge
  // etc.
}