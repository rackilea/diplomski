System.out.println(line);
char x;
if (line.length() < 1) {
   System.out.println("next line is empty");
} else {
    x = line.charAt(0);

    while((line.charAt(0)!='/')&&(Character.isWhitespace(x)==false))
    {
       line = inputFile.nextLine();
       if (line.length() < 1) {
          System.out.println("next line is empty");
          break;
       }
       x = line.charAt(0);
       System.out.println(line);
       System.out.println(x);
    }
}