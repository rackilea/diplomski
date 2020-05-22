Element composite = doc.getRootElement(); 
if(composite != null) 
{
    composite.setAttribute("xmlns:xsi", "http://www.w3.org/2001/XMLSchema-
    instance");

    composite.setAttribute("xsi:noNamespaceSchemaLocation", "v1_6.xsd");
}