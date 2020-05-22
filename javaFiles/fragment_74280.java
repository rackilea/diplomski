private static String getSubString(List<String> subs, String myString) {
   if(subs !=null && subs.size() != 0) {
       myString = myString.replace(subs.get(0), "");
       subs.remove(0);
       getSubString(subs, myString);
   }
   return myString;
}