public final static Document XMLfromString(String xml)
{
    if(xml!=null)
    {
    /* Replace the & in string with &amp (if any) */
        String xmlNew=clearRefs(xml);
        Document doc = null;
    //  Log.v(tag,"After Clearing refs::"+xmlNew);
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        Log.v(tag,"Trying Obtaining Document");
        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            InputSource is = new InputSource();
            is.setCharacterStream(new StringReader(xmlNew));
            doc = db.parse(is); 
        } catch (ParserConfigurationException e) {
            Log.e(tag,"XML parse error: " + e.getMessage());
            return null;
        } catch (SAXException e) {
            connectionStatus="No data received";
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            Log.e(tag,"I/O exeption: " + e.getMessage());
            connectionStatus="No data received";
            return null;
        }
        return doc;
    }
    else
    {
        connectionStatus="Null string Passed";
        return null;
    }
}