@ApiImplicitParams({
    @ApiImplicitParam(name = "modelId", value = "this is modelId", required = true, dataType = "string", paramType = "query"),
    @ApiImplicitParam(name = "makeId", value = "this is makeId", required = true, dataType = "string", paramType = "query")
  })
  @RequestMapping(method = RequestMethod.GET, value = "/model")
  public SearchModelsResponse searchModels(
      final ModelSearch search) {...}