public static void main(String args[]){
 // There is no use of this arraylist, if the author you're looking for is hard-coded
 ArrayList<Author> authors = new ArrayList<Author>(); 
 authors = loadAuthors(); 
 ArrayList<Book> books = new ArrayList<Book>(); 
 books = loadBooks(authors);

 // iterate over the arraylist of Books
 for(Book b : books){ 
  // Get all the authors for the current Book obj
  ArrayList<Author> bookAuthors = b.getAuthors();

  // Iterate over the author's of that specific book arraylist 
  for(Author ar: bookAuthors){

   // Match condition that must be satisfied.
   if(ar.getFirst().equals("Ayn") && ar.getLast.equals("Rand")){

     // Do something here, like printing the book written by Ayn, or something else
     System.out.println(b.getTitle());
   }
  }
 }
}