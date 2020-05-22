public void call(String soapAction, SoapEnvelope envelope) throws IOException, XmlPullParserException
{
    if(localFileAvailable)
    {
        InputStream is = new FileInputStream(fileWithXml);
        parseResponse(envelope, is);
        is.close();
    }
    else
    {
        super.call(soapAction, envelope);
    }
}