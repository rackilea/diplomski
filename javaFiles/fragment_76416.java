class MyDocument {
  ObjectID id;
  List<Result> results;
  …
}

class Result {
  int position;
  @DBRef Product product;
  …
}

class Product {
  ObjectId id;
}