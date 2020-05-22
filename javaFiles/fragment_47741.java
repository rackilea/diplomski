public String getSqlLikeString(String givenString) {
   System.out.println(givenString); 
   givenString = givenString.replaceAll("\"", "\\\""); 
   System.out.println(givenString); 
   return givenString;
}

// or just
public String getSqlLikeString(String givenString) {
   return givenString.replaceAll("\"", "\\\"");
}