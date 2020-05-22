public <T> List<T> filter(Predicate<T> predicate, List<T> source) {
  List<T> result = new ArrayList<>();
  for(T item : source) {
    if(predicate.evaluate(item)){
         result.add(item);
    }
   return result;
  }
}