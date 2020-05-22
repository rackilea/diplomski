public static void main (String[] args)
{
      Scanner scan = new Scanner(System.in);
      System.out.print("Type in String:");
      String theString = scan.nextLine();
      theString = theString.replaceAll("\\s+", " ");
      char [] convert = theString.trim().toCharArray();
      convert[0] = Character.toUpperCase(convert[0]);
      for(int i = 0; i < convert.length; i++){
           if(Character.isWhitespace(convert[i])){
                convert[i+1] = Character.toUpperCase(convert[i+1]);
          }
      }
      String newString =  String.valueOf(convert);
      System.out.println(newString);    
}