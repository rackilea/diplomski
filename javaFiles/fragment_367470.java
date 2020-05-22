import org.apache.commons.lang.SerializationUtils;
/**
* testSerializeAndDeserialize.
*
**/
public void testSerializeAndDeserialize throws Exception {

//serialize here
    byte[] bytes = SerializationUtils.serialize("your object here which is of type f  .pdf, .doc and .txt ");


 // deserialize the same here and see you are getting back or not.
 yourobjecttype objtypeofpdfortxtordoc = (yourobjecttype) SerializationUtils.deserialize(bytes);

}