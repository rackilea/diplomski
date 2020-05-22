public void GetLatestData(SoapPrimitive xml)throws ParserConfigurationException, SAXException, IOException{
    //get the factory
    DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

    //Using factory get an instance of document builder
    DocumentBuilder db = dbf.newDocumentBuilder();
    Document doc;

    //parse using builder to get DOM representation of the XML file
    InputSource is = new InputSource(new StringReader(xml.toString()));
    doc = db.parse(is);

   //Clear out Issues table first.
   creator = new IssueInfoCreator(this, DBVersion);
   creator.open();
   creator.ClearIssueTable();
   creator.close();

   NodeList nodes = doc.getElementsByTagName("Table");

   for(int i = 0; i < nodes.getLength(); i++) {
       IssueInfo issue = new IssueInfo();

       Element e = (Element)nodes.item(i);

       issue.setIssueNumber(Long.parseLong(XMLfunctions.getValue(e, "IssueID")));
       issue.setIssueSummary(XMLfunctions.getValue(e, "IssueSummary"));
       issue.setDateReceived(DateFormat.format("MM/dd/yyyy hh:mm:ss", System.currentTimeMillis()).toString());

       if(issue.getIssueNumber() > 0 && issue.getIssueSummary() != null){
           creator = new IssueInfoCreator(this, DBVersion);
           creator.open();
           creator.InsertIssue(issue.getIssueNumber(), issue.getDateReceived(), issue.getIssueSummary());
           creator.close();
       }
   }
}