@PATH("/items/{identifier}")
public String getItem(@PathParam("identifier") String identifier){
   try {
       return getByID( Long.parseLong(identifier) );
   } catch (NumberFormatException ex) {
       return getByName( identifier );
   }
}