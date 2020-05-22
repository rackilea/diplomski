soap = (SoapObject) envelope.bodyIn
soapResult = (SoapObject)soap.getProperty(0);
for(int i=0;i<soapResult.getPropertyCount();i++)
{
   SoapObject so = (SoapObject) soapResult.getProperty(i);
 //here, you can get data from xml using so.getProperty("PublicationID") 
 //or the other tag in xml file.
}