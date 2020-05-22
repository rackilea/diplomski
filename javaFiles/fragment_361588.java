new Settings().withRenderMapping(new RenderMapping()
  .withSchemata(new MappedSchema()
    .withInput("develop")
    .withOutput("stage")
  )
);