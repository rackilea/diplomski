class Book {
  String id;
  String name;
}

class Review {
  String bookId;
  String text;
}

class QueryResult {
  Book book;
  Review review;
}