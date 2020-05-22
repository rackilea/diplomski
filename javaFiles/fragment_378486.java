[...]    
public String getValueOfElement (String filename, String what){

            try{

                DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();

                DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();

                Document document = documentBuilder.parse(context.openFileInput(filename));

                String lookingFor = document.getElementsByTagName(what).item(0).getTextContent();

                return lookingFor;


            } catch (FileNotFoundException e) {
                System.err.println("----------------- File not found -----------------");
                e.printStackTrace();
                return "";
            } catch (ParserConfigurationException e) {
                System.err.println("----------------- Error creating DocumentBuilder -----------------");
                e.printStackTrace();
                return "";
            } catch (SAXException e) {
                System.err.println("----------------- Error creating the document(Sax) -----------------");
                e.printStackTrace();
                return "";
            } catch (IOException e) {
                System.err.println("----------------- Error creating the document(IO) -----------------");
                e.printStackTrace();
                return "";
            }
        }
[...]