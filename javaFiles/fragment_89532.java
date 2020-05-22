new ByteBuddy()
  .subclass(Object.class)
  .annotateType(AnnotationDescription.Builder.ofType(RunWith.class)
                                             .define("value", SomeRunner.class)
                                             .build())
  .make();