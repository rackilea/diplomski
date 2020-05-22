public static void main(String[] args) {
    XWPFDocument doc = null;

    try {
        //Input Word Document
        File file = new File("C:/TestDoc.docx");
        FileInputStream in = new FileInputStream(file);
        doc = new XWPFDocument(in);

        //Determine how many paragraphs per page
        List<Integer> paragraphCountList = getParagraphCountPerPage(doc);

        if (paragraphCountList != null && paragraphCountList.size() > 0) {
            int docCount = 0;
            int startIndex = 0;
            int endIndex = paragraphCountList.get(0);

            //Loop through the paragraph counts for each page
            for (int i=0; i < paragraphCountList.size(); i++) {
                XWPFDocument outputDocument = new XWPFDocument();

                List<XWPFParagraph> paragraphs = doc.getParagraphs();
                List<XWPFParagraph> pageParagraphs = new ArrayList<XWPFParagraph>();

                if (paragraphs != null && paragraphs.size() > 0) {
                    //Get the paragraphs from the input Word document
                    for (int j=startIndex; j < endIndex; j++) {
                        if (paragraphs.get(j) != null) {
                            pageParagraphs.add(paragraphs.get(j));
                        }
                    }

                    //Set the start and end point for the next set of paragraphs
                    startIndex = endIndex;

                    if (i < paragraphCountList.size()-2) {
                        endIndex = endIndex + paragraphCountList.get(i+1);
                    } else {
                        endIndex = paragraphs.size()-1;
                    }


                    //Create a new Word Doc with the paragraph subset
                    createPageInAnotherDocument(outputDocument, pageParagraphs);

                    //Write the file
                    String outputPath = "C:/TestDocOutput"+docCount+".docx";
                    FileOutputStream outputStream = new FileOutputStream(outputPath);
                    outputDocument.write(outputStream);
                    outputDocument.close();

                    docCount++;
                    pageParagraphs = new ArrayList<XWPFParagraph>();
                }
            }
        }

    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        try {
            doc.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}


private static List<Integer> getParagraphCountPerPage(XWPFDocument doc) throws Exception {
    List<Integer> paragraphCountList = new ArrayList<>();
    int paragraphCount = 0;

    Document domDoc = convertStringToDOM(doc.getDocument().getBody().toString());
    NodeList rootChildNodeList = domDoc.getChildNodes().item(0).getChildNodes();

    for (int i=0; i < rootChildNodeList.getLength(); i++) {
        Node childNode = rootChildNodeList.item(i);

        if (childNode.getNodeName().equals("w:p")) {
            paragraphCount++;

            if (childNode.getChildNodes() != null) {
                for (int k=0; k < childNode.getChildNodes().getLength(); k++) {
                    if (childNode.getChildNodes().item(k).getNodeName().equals("w:r")) {
                        for (int m=0; m < childNode.getChildNodes().item(k).getChildNodes().getLength(); m++) {
                            if (childNode.getChildNodes().item(k).getChildNodes().item(m).getNodeName().equals("w:br")) {

                                paragraphCountList.add(paragraphCount);
                                paragraphCount = 0;
                            }
                        }
                    }
                }
            }
        }
    }

    paragraphCountList.add(paragraphCount+1);

    return paragraphCountList;
}


private static Document convertStringToDOM(String xmlData) throws Exception {
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    DocumentBuilder builder = factory.newDocumentBuilder();

    Document document = builder.parse(new InputSource(new StringReader(xmlData)));    

    return document;
}


private static void createPageInAnotherDocument(XWPFDocument outputDocument, List<XWPFParagraph> pageParagraphs) throws IOException {
    for (int i = 0; i < pageParagraphs.size(); i++) {
        addParagraphToDocument(outputDocument, pageParagraphs.get(i).getText());
    }
}


private static void addParagraphToDocument(XWPFDocument outputDocument, String text) throws IOException {
    XWPFParagraph paragraph = outputDocument.createParagraph();
    XWPFRun run = paragraph.createRun();
    run.setText(text);
}