public static void main(String[] args)
  {         
      printSwapped("baby");
  }

 static void printSwapped(String str) {
     if(str.length()<=1) {
         System.out.print(str);
     }else {
         System.out.print(str.charAt(1));
         System.out.print(str.charAt(0));
         printSwapped(str.substring(2));
     }       
 }