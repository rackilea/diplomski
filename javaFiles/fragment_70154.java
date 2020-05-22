import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.DeserializationProblemHandler;

public class LicenceDeserializationProblemHandler extends DeserializationProblemHandler {

        @Override
        public Object handleUnexpectedToken(DeserializationContext ctxt, Class<?> targetType, JsonToken t, JsonParser p,
                        String failureMsg) throws IOException {
                if(ArrayList.class.isAssignableFrom(targetType) && 
                                JsonToken.VALUE_STRING.equals(t)) {
                        // If there is no license a XML-Comment is in the licenses token.
                        return null;
                }else {
                        return super.handleUnexpectedToken(ctxt, targetType, t, p, failureMsg);
                }
        }   
}