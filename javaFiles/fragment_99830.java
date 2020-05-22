public Observable<List<String>> uploadKeys(Map<String,String> entries) {
  return Observable.fromIterable( entries.entrySet )
           .flatMap( entry -> storeKeysInTheDb( entry.getKey(), entry.getValue() )
           .filter(element -> !element.isEmpty())
           .toList();
}