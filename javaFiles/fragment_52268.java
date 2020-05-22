@RequestMapping(method = {RequestMethod.GET,RequestMethod.POST}, value ="/listeningurl", consumes = "application/xml", produces = "application/xml") 
     public ResponseObject lodgementNotifications(@RequestBody String reqObjectXMLStr)
     {

          //Replace the backslashes from the xml string
          String cleanReqObjectXMLStr = reqObjectXMLStr.replaceAll("\\\\", "");

        //Unmarshal the string into the corresponding object using JAXB library 
         RequestObject reqObject = JAXB.unmarshal(new StringReader(cleanReqObjectXMLStr), RequestObject.class);

        //do stuffs with reqObject;

                // Initialize and set ResponseObject
              return responseObject

    }