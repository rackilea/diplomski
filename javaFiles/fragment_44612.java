public Map<QName, String> getConvertedAttributes() throws Exception
{
    if(!convertedAttributes.isEmpty()) {
        return convertedAttributes;
    }
    if ( attributes != null ) {
        convertedAttributes = new AttributeMapAdapter().marshal( attributes ); 
    } else {
        convertedAttributes = new HashMap<QName, String>();
    }
    return convertedAttributes;
}