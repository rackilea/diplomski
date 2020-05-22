public static void main(String[] args){

     String[] array = new String[10]; //creates an array of size ten
     for(int i=0;i<array.length();i++){
         String string ="";
          for(int x=0;x<i;x++)
               string += "x";
          array[i]= string;
     }
 }