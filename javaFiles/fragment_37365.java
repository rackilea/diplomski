@Converter
public class MyObjectConverter implements AttributeConverter<MyObject, String> {
 @Override
 public String convertToDatabaseColumn(MyObject myObject) {
    //convert myobject to json: for instance use ObjectMapper from Jackson
    if( myObject == null )
        return null;

    ObjectMapper mapper = new ObjectMapper();
    return mapper.writeValueAsString(myObject );
 }

 @Override
 public MyObject convertToEntityAttribute(String myObjectString) {
    // convert myObjectString back to object
    if( myObjectString== null )
        return null;

    ObjectMapper mapper = new ObjectMapper();
    return mapper.readValue(myObjectString, MyObject.class);
 }  
}