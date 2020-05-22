private final static String USERNAME_ATTRIBUTE_NAME = "urn:oid:0.9.2342.19200300.100.1.3"

private String getUsername(Assertion assertion)
{
    for (AttributeStatement attributeStatement : assertion.getAttributeStatements())
    {
        for (Attribute attribute : attributeStatement.getAttributes())
        {
            if (USERNAME_ATTRIBUTE_NAME.equals(attribute.getName()))
            {
                List<XMLObject> attributeValues = attribute.getAttributeValues();
                if (!attributeValues.isEmpty())
                {
                    return getAttributeValue(attributeValues.get(0));
                }
            }
        }
    }
    throw new IllegalArgumentException("no username attribute found");
}