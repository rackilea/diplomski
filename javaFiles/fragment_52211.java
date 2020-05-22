public static void main(String[] args){

     String[] array = new String[10]; //creates an array of size ten
     for(int i=0;i<array.length();i++){
         StringBuilder string =new StringBuilder();
          for(int x=0;x<i;x++)
               string.append("x");
          array[i]= string.toString();
     }
 }