package com.alexfrndz;

import org.mule.api.MuleMessage;
import org.mule.api.transformer.TransformerException;
import org.mule.transformer.AbstractMessageTransformer;

public class PersonTransformer extends AbstractMessageTransformer {

   @Override
   public Object transformMessage(MuleMessage message, String outputEncoding) throws TransformerException {
       Person person = (Person) message.getPayload();
       //Do your transformation hear
    return null;
    }

}