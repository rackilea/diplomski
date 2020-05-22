try {

   Scanner input = new Scanner(inFile);
   input.useDelimiter("\\t|[\\n\\r\\f]+");

   while (input.hasNext()) {

    try{
       String artist = input.next();
       String title = input.next();
       int year = input.nextInt();

   Album albumObject = new Album(title,artist,year,rank);

     addAlbum(albumObject);
      count ++;
      rank++;
}
catch (InputMismatchException exception)
{
    System.out.println("ERROR: Line "+(count+1)+": Invalid input for  year. Skipping line.");
}

    }
 }
// This exception will not occur unless I give it a file input that does not  exist.
catch (FileNotFoundException exception)
{
    System.out.println("The file  was not found.");
}
 /* This exception works fine.However, the Scanner should continue reading  the file
 * inputs just skipping the 5th line where the mismatch occur.My program for some reason
 * is not printing any more input after skipping the line and that is my  problem.
 */