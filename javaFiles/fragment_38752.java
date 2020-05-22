HashMap<String, Boolean> map;

public boolean testRule(String stringInput) {
   Boolean result = map.get(stringInput);

   if (result == null) {
       //calculate and set in map
   }

   return result;
}