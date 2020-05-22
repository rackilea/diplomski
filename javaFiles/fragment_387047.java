/**
*@param s string to HTML
*
*/
String convert(String s){
  while(s.indexOf("_")!= -1 ||s.indexOf("*") != -1){
           if(s.indexOf("_") != -1){
               s = s.replaceFirst("\\_", "<i>");
               s = s.substring(0, s.lastIndexOf("_"))+"</i>"+s.substring(s.lastIndexOf("_")+1);
           } 

           if(s.indexOf("*") != -1){
               s = s.replaceFirst("\\*", "<b>");
               s = s.substring(0, s.lastIndexOf("*"))+"</b>"
               +s.substring(s.lastIndexOf("*")+1);
           } 

     }//end while

return s;
}