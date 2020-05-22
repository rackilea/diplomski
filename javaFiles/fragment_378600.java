public static final void exampleService(IData pipeline) throws ServiceException {
  IDataCursor pipelineCursor = pipeline.getCursor();

  try {
    // create an intermediateDoc IData object
    IData intermediateDoc = IDataFactory.create();
    // create a cursor to use to add key value tuples to the intermediateDoc
    IDataCursor intermediateCursor = intermediateDoc.getCursor();
    // add key value tuples as required to the intermediateDoc
    IDataUtil.put(intermediateCursor, "key1", "value1");
    IDataUtil.put(intermediateCursor, "key2", "value2");
    // ...
    // destroy the intermediateCursor when done adding key value tuples
    intermediateCursor.destroy();

    // create an outputDoc IData object
    IData outputDoc = IDataFactory.create();
    // create a cursor to use to add key value tuples to the outputDoc
    IDataCursor outputCursor = outputDoc.getCursor();
    // add the intermediateDoc to the outputDoc
    IDataUtil.put(outputCursor, "intermediateDoc", intermediateDoc);
    // destroy the outputCursor when done adding key value tuples
    outputCursor.destroy();

    // add the outputDoc to the pipeline
    IDataUtil.put(pipelineCursor, "outputDoc", outputDoc);
  } finally {
    // destroy the pipelineCursor
    pipelineCursor.destroy();
  }
}