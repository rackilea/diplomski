public String findLastMissingElement(String[] constants, List<String> hand){
   String missingElement = null;
   for (String constant : constants){

       if (!hand.contains(constant) && missingElement==null){ 
          missingElement = constant;
       }
       else if (!hand.contains(constant)){ 
         return null;
       }
   }
   return missingElement;
}