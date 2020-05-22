public Document getDomElement(String xml){
            Document doc = null;
<-------------LIKE THIS--------------------------->
            String var = CustomizedListView.URL;
<---------------------------------------->
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            try {

                DocumentBuilder db = dbf.newDocumentBuilder();

                //InputSource is = new InputSource();
                  //  is.setCharacterStream(new StringReader(xml));
                    doc = db.parse(var);