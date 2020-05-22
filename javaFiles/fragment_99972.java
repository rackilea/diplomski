int offset, length; //The value of the first 2 parameters in the setParagraphAttributes() call

Element section = doc.getDefaultRootElement();
int index0 = section.getElementIndex(offset);
int index1 = section.getElementIndex(offset + ((length > 0) ? length - 1 : 0));
for (int i = index0; i <= index1; i++)
{
    Element paragraph = section.getElement(i);
    AttributeSet attributeSet = paragraph.getAttributes();
    Enumeration keys = attributeSet.getAttributeNames();
    while (keys.hasMoreElements())
    {
        Object key = keys.nextElement();
        Object attribute = attributeSet.getAttribute(key);
        //System.out.println("key = " + key); //For other AttributeSet classes this line is useful because it shows the actual parameter, like "Bold"
        System.out.println(attribute.getClass());
        System.out.println(attribute);
    }
}