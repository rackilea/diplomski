public class MyAwesomeJson extends JacksonObject implements S {

   private final String value;

   public MyAwesomeJson(String value) {
     this.value = value;
   }

   @JsonValue
   public String getValue() {
     return value;
   }
}