public static String formatData(String str){
   String[] temp = str.split(" ");
   if(temp.length > 2){
      return temp[1]+" "+temp[0]+" "+temp[2];
   }else{
      // can't perform.
      return str;
   }
}