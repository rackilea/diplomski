public void parseBytes(byte[] bytes, int length, String source)
{               
    String foundData = null;
    try
    {
        foundData = new String(bytes, 0, length, "UTF-8");
    }
    catch (UnsupportedEncodingException e1)
    {
        e1.printStackTrace();
    }
    switch (readState)
    {             
    case STATE_NEW_MSG:
        // if contains the 
        if (foundData.contains(startMessageTag))
        {
            if (foundData.contains(endMessageTag))
            {   
                byteStream.write(bytes, 0, length);                   
                parseXml(byteStream.toByteArray());
                if (byteStream.size() > 0)
                {
                    byteStream.reset();
                }
            }
            else
            {                    
                readState = DrawingDeviceParserState.STATE_READING_MSG;
            }                
        }
        else
        {
            System.out.println("Couldn't find start tag");
            System.out.println(foundData);
        }
        break;

    case STATE_READING_MSG:          
        byteStream.write(bytes, byteStream.size(), length);
        if (foundData.contains(endMessageTag))
        {
            System.out.println("Now going to parse");
            //parseXml(xmlString.toString());
            parseXml(byteStream.toByteArray());
            byteStream.reset();
            readState = DrawingDeviceParserState.STATE_NEW_MSG;
        }
        else
        {
            System.out.println("Couldn't find end tag");
            System.out.println(foundData);
        }
        break;
    }                        
}

    private void parseXml(byte[] xmlData)
    {
        System.out.println(xmlData);

        //EventDocument.Factory.parse
        ByteArrayInputStream sid = new ByteArrayInputStream(xmlData);     
        try
        {
            EventDocument eventDoc = EventDocument.Factory.parse(sid);
            if (eventDoc.validate())
            {
                System.out.println("Document is valid");
            }
            else
            {
                System.out.println("Document is INVALID");
            }
            EventDocument.Event myEvent = eventDoc.getEvent();
            EventDocument.Event.Detail[] myDetailArray = myEvent.getDetailArray();

            //myDetailArray[0].

            //BmsDrawingDocument drawingDoc = myEvent.getDetail();
            System.out.println("MY UID: " + myEvent.getUid());
        }
        catch(Exception xmlException)
        {
            System.out.println(xmlException.toString());
            xmlException.printStackTrace();
        }
}