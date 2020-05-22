public Book checkBook(String title, String author)
{
   for(Book allbooks : books)
   {
       if(allbooks.getTitle().equals(title) && allbooks.getAuthor().equals(author)) {
           return allbooks;
       }
   }
   return null;
}