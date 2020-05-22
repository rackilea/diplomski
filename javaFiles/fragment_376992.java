ArrayList<String> words = new ArrayList<String>();

Scanner reader = new Scanner(System.in);
String name;
while(true){
   System.out.print("Type a word: ");
   name  = reader.nextLine();        

   if (words.contains(name)) {
       break;
   }
   words.add(name);


}
System.out.println("You gave the word " + name + " twice");