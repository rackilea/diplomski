private static Double calculatePermutationEntropy(List<Double> values, int baseOrder) {
 int valuesSize = values.size();
 if (baseOrder >= valuesSize + 1) {
   throw new RuntimeException("The size of the values is bigger than the order");
 }

 List<String> result = new ArrayList<String>();
 // iterate over the input
 for (int i = 0; i < valuesSize - baseOrder + 1; i++) {
   List<Double> neightbors = values.subList(i, i + baseOrder);

   List<Double> orderedValues = new ArrayList<Double>(neightbors);

   String window = "";
   for (int j = 0; j < neightbors.size(); j++) {
     // add the indexes in a string representation
     window += orderedValues.indexOf(neightbors.get(j));
   }
 result.add(window);
 }
 // use the shannon entropy calculation to get the result
 return calculateShannonEntropy(result);
}