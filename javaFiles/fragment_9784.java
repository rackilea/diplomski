class GraphBuilder(g: Graph ) {
  def variable(name: String, dataType: DataType, shape: Shape): Output = {
    g.opBuilder("Variable", name)
      .setAttr("dtype", dataType)
      .setAttr("shape", shape)
      .build()
      .output(0)
  }

  def assign(value: Output, variable: Output): Output = {
      graph.opBuilder("Assign", "Assign/" + variable.op().name()).addInput(variable).addInput(value).build().output(0)
  }
}

val WValue = Array.fill(numFeatures)(Array.fill(hiddenDim)(0.0))
val W = builder.variable("W", DataType.DOUBLE, Shape.make(numFeatures, hiddenDim))
val W_init = builder.assign(builder.constant("Wval", WValue), W)