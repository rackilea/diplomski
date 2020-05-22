public class SomeClassWithFields {
   @SerializedName("name") private final String someField;
   private final String someOtherField;

   public SomeClassWithFields(String a, String b) {
     this.someField = a;
     this.someOtherField = b;
   }
 }