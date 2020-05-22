public class Bike {
   @NotEmpty
   private String name;

   @Valid
   @ConvertGroup(from = Default.class, to = BasicEngineChecks.class)
   private Engine engine; 

   // ...
}