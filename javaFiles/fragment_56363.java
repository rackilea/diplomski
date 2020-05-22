public class PayloadValidationgInterceptorCustom extends
PayloadValidatingInterceptor {

@Override
protected boolean handleRequestValidationErrors(MessageContext messageContext, SAXParseException[] errors)
        throws TransformerException {
    messageContext.getRequest().writeTo(/*place your Outputstream here something like a ByteArrayOutputStream*/); //use this if you want to dump the message
    for (SAXParseException error : errors) {
        //dump the each error on the db o collect the stack traces in a single string and dump only one or to the database
       /*you can use something like this
         StringWriter sw = new StringWriter();
         PrintWriter pw = new PrintWriter(sw);
         error.printStackTrace(pw);
         sw.toString();
         to get the stack trace
        */

    }
    return super.handleRequestValidationErrors(messageContext,errors);

}