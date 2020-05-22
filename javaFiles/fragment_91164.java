CountOddsFn countOdds = new CountOddsFn();
pipeline
  .apply(Create.of(1, 3, 5, 7, 2, 4, 6, 8, 10, 12, 14, 20, 42, 68, 100))
  .apply(ParDo.of(countOdds));
PipelineResult result = pipeline.run();
// Here you may need to use the BlockingDataflowPipelineRunner 

AggregatorValues<Integer> values =
result.getAggregatorValues(countOdds.aggregator);
Map<String, Integer> valuesAtSteps = values.getValuesAtSteps();
// Now read the values from the step...