public void displayLongBooks()
{
  System.out.println();
  System.out.println("LONG BOOKS");
  for (Book b : bookList) { // <-- for each Book b in bookList
    if (b.isLong()) { // no need for == true
      System.out.println(b); // <-- b, not bookList
    }
  }
}