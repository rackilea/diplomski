public class Demonstration {

   @CsvBindByName(column = "index")
   private String index;

   @CsvBindAndJoinByName(column = ".*", elementType = String.class)
   private MultiValuedMap<String, String> theRest;

   // Getters and setters go here
}