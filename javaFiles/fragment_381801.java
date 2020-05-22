@Converter
  public class BoolToString implements AttributeConverter<Boolean, 
String> {
  @Override
  public String convertToDatabaseColumn(Boolean value) {
  if (value == null) return "-";
  else return value ? "Y" : "N";
 }

 @Override
 public Boolean convertToEntityAttribute(String value) {
  if (value.equals("-") return null;
  else if (value.equals("Y")) return true;
  else if (value.equals("N")) return false;
  else throw new IllegalStateException("Invalid boolean character: " + 
  value);
 }