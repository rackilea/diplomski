public class MyMessageCodesResolver extends DefaultMessageCodesResolver {

public static final String NOT_NULL_ERROR_CODE = "NotNull";

@Override
public String[] resolveMessageCodes(String errorCode, String objectName, String field, Class fieldType) {
   if(NOT_NULL_ERROR_CODE.equalsIgnoreCase(errorCode)) {
       String notNullErrorCode = errorCode + CODE_SEPARATOR + objectName + CODE_SEPARATOR + field;
       //notNullErrorCode = postProcessMessageCode(notNullErrorCode);
       return new String[] {notNullErrorCode};
    }
      return super.resolveMessageCodes(errorCode, objectName, field, fieldType);
}   
}