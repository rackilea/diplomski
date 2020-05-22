private String getAttributeValue(XMLObject attributeValue)
{
    return attributeValue == null ?
            null :
            attributeValue instanceof XSString ?
                    getStringAttributeValue((XSString) attributeValue) :
                    attributeValue instanceof XSAnyImpl ?
                            getAnyAttributeValue((XSAnyImpl) attributeValue) :
                            attributeValue.toString();
}

private String getStringAttributeValue(XSString attributeValue)
{
    return attributeValue.getValue();
}

private String getAnyAttributeValue(XSAnyImpl attributeValue)
{
    return attributeValue.getTextContent();
}