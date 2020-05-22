public static String findFirstDuplicate(String string){

                 for(int i=0;i<string.length()-1; i++){
                     String c=string.charAt(i)+"";
                     if(string.indexOf(c, i+1)>-1)
                         return  c;
                 }

                 return null;
  }