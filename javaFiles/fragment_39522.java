@Converter
      public class IinegerToStringConverter implements AttributeConverter<Integer, 
    String> {
      @Override
      public String convertToDatabaseColumn(Integer value) {
    try {
          return Integer.toString(number);
      }
      else throw new IllegalStateException("Invalid number: " + 
      value);
     }

 @Override
 public Integer convertToEntityAttribute(String number) {
  try {
      return Integer.parseInt(number);  
  } catch(Exception e){
  throw new IllegalStateException("Invalid number: " + 
  value);
 }