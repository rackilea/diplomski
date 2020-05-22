Scanner scanner= new Scanner(new File("filename.txt"));
String lines = "";
while(scanner.hasNextLine()){
    String stringLine = scanner.nextLine();
    if(stringLine.indexOf("YOUR_WORD") != -1){
        //print whatever you want here
         System.out.println(stringLine);
      //add every line that contains stringLine into another string;
      lines+=stringLine;
    }
}