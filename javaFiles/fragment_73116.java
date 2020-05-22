// A TensorFlow "model" that reshapes a string scalar into a vector.
// Should be much prettier once https://github.com/tensorflow/tensorflow/issues/7149
// is resolved.
private static class Reshaper implements AutoCloseable {
  Reshaper() {
    this.graph = new Graph();
    this.session = new Session(graph);
    this.in =
        this.graph.opBuilder("Placeholder", "in")
            .setAttr("dtype", DataType.STRING)
            .build()
            .output(0);
    try (Tensor shape = Tensor.create(new int[] {1})) {
      Output vectorShape =
          this.graph.opBuilder("Const", "vector_shape")
              .setAttr("dtype", shape.dataType())
              .setAttr("value", shape)
              .build()
              .output(0);
      this.out =
          this.graph.opBuilder("Reshape", "out").addInput(in).addInput(vectorShape).build().output(0);
    }
  }

  @Override
  public void close() {
    this.session.close();
    this.graph.close();
  }

  public Tensor vector(Tensor input) {
    return this.session.runner().feed(this.in, input).fetch(this.out).run().get(0);
  }

  private final Graph graph;
  private final Session session;
  private final Output in;
  private final Output out;
}