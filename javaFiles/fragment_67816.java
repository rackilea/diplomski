public MyString() {
   array = new char[25];
   max = 25;

   size = 0;
}

public void setString(String newString) {
   if(newString.length() > 25) {
      System.out.println("/nEnter a number equal or less than 25 " );
   } else {
      size = newString.length();

      for(int i = 0; i < size; i++) {
          array[i] = newString.charAt(i);
      }
   }
}

public int length() {
   return size;
}