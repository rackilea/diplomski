class ThresholdFilter implements Filterable {
  private threshold;
  ThresholdFilter(threshold) {
    this.threshold = threshold;
  }

  bool filter(book) {
    return book.sales >= this.threshold;
  }
}

function bestSellingBooks(threshold) {
  return bookList.filter(new ThresholdFilter(threshold));
}