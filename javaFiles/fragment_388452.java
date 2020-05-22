while ((line = br.readLine()) != null)
{
   // insert code to break input to pieces
   StringTokenizer tokenizer = new StringTokenizer(line) ;
   while (tokenizer.hasMoreElements())
   {
     String bookName = tokenizer.nextToken();
     String author = tokenizer.nextToken();
     String isbn = tokenizer.nextToken();
     String year = tokenizer.nextToken();

     list.insert(bookName, author, isbn, year) ;
   }
   System.out.println (line) ;
}