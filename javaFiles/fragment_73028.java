public class CustomAggregation extends Aggregation {
      List<AggregationOperation> getAggregationOperations() {
      return operations;
   }
}

public Aggregation newCustomAggregation(Aggregation aggregation, Criteria c) {
     CustomAggregation customAggregation = (CustomAggregation) aggregation;
     List<AggregationOperation> listOperations = customAggregation.getAggregationOperations();
     listOperations.add(Aggregation.match(c));
     return Aggregation .newAggregation(listOperations);
 }