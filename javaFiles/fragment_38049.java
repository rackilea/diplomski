public static int indexOfIgnoreCase(String[] strs, String text){

   int n = strs.length;
   for(int i=0;i<n;i++){
       if(strs[i].equalsIgnoreCase(text))
         return i;
   }
   return -1;
}
int n = indexOfIgnoreCase(Names,textBox.getText());