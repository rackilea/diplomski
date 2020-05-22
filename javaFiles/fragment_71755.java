static Object deformatTypedElement(int datatype, String value)
    throws JMSException
{
    Object result = null;
    switch (datatype) {
        ...
        case 1:
            if (value.equals("1")) {
                result = new Boolean(true);
            }
            else if (value.equals("0")) {
                result = new Boolean(false);
            }
            else {
                JMSException je = (JMSException)NLSServices.createException("JMSCMQ0008", null); // Line 306 - BOOM!
                throw je;
            }

            // There is also no break here but I think it is a problem of decompiler
       ...
    }
}