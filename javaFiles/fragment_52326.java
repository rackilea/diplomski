public static void createPipeline(DoFn<Foo, Baz> dofn) {
  Pipeline pipeline = TestPipeline.create();

  pipeline
      .apply(Read.from(new Source()))
      .apply(ParDo.of(dofn));

  pipeline
      .apply(Read.from(new AnotherSource()))
      .apply(ParDo.of(dofn));

  pipeline.run();
}