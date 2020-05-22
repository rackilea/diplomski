InputStream is = getResources().openRawResource(R.raw.content);
    DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();

        DocumentBuilder dBuilder;
            try {
                dBuilder = dbFactory.newDocumentBuilder();
                try {
                    Document doc = dBuilder.parse(is,"UTF-8");
                    NodeList nl = doc.getElementsByTagName("main");

                    System.out.println("NodeList NodeList"+nl.getLength());

                } catch (SAXException e) {
                    // TODO Auto-generated catch block

                    e.printStackTrace();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } //Blows up right here.
            } catch (ParserConfigurationException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }