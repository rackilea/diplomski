try{
   File file = new File("Numbers.txt");
   Scanner inputFile = new Scanner(file);
   while (inputFile.hasNext()){
    String next = inputFile.next();
    try{
        numbers.add(Integer.valueOf(next));
     }catch(NumberFormatException nfe){
       //not a number, ignore it
     }
   }
 }catch(IOException ioe){
      ioe.printStackTrace();
 }