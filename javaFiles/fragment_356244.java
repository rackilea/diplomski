// Return a list of all books with at least 'threshold' copies sold.
function bestSellingBooks(threshold) {
  return bookList.filter(
      function (book) { return book.sales >= threshold; }
    );
}