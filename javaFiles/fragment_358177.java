public class AddValuesBusinessLogic extends AbstractMessageTransformer 
{
    @Override
    public Object transformMessage(MuleMessage message, String outputEncoding) throws 
    TransformerException 
    {
        MuleMessage muleMessage = message;
        AddValues addValues = (AddValues) muleMessage.getPayload();
        if (addValues.getA() == null || addValues.getB() == null ) {
        //Make an AddValueException object
        throw new TransformerException(this,new AddValueException("BAD REQUEST"));
    }
    return "ALL OK";}