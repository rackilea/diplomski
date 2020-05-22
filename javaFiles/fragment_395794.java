public Optional<String> myMethod(String location) {
   if (location.equals("location1")) {
     return Optional.empty();//returns empty Optional object
   } else {
     return Optional.of(output);//returns String wrapped by Optional
   }
}