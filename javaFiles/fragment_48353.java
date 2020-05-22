try
{
    ...
    ...
    validator.validate(source); 
}
catch (SAXException saxe)
{
    System.out.println("SAXException occurred");
    SOAPFault fault = null;
    try
    {
        fault = SOAPFactory.newInstance().createFault();
        fault.setFaultString(saxe.getMessage());
    }
    catch (SOAPException soape)
    {
        LOG.error("Error creating SOAPFault: "+soape.getMessage());
    }
    throw new SOAPFaultException(fault);
}