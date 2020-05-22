private void parseXmlFile(){
        //get the factory
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
    try {
        //using Factory get an instance of document builder
        DocumentBuilder db = dbf.newDocumentBuilder();
        //parse using builder to get DOM representation 
       Document  dom = db.parse("Employee.xml"); 
    } catch(IOException ex ){ // OR Any Specific Exception should be catched here
// your error handling code here
}

    }