String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<config>\n" +
                "    <apps>\n" +
                "        <app name=\"app1\">\n" +
                "            <url>someUrl</url>\n" +
                "            <username>user1</username>\n" +
                "            <password>qwerty123</password>\n" +
                "        </app>\n" +
                "        <app name=\"app2\">\n" +
                "            <url>someUrl</url>\n" +
                "            <username>user2</username>\n" +
                "            <password>asdasdasd</password>\n" +
                "        </app>\n" +
                "        <app name=\"app3\">\n" +
                "            <url>someUrl</url>\n" +
                "            <username>user3</username>\n" +
                "            <password>123456789</password>\n" +
                "        </app>\n" +
                "    </apps>\n" +
                "</config>";
//here use your InputStream for example from file
        InputStream inputStream = new ByteArrayInputStream(xml.getBytes());


        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(inputStream);
        doc.getDocumentElement().normalize();

        doc.getElementsByTagName("password").item(0).getFirstChild().setNodeValue("new content");
//here use your outputStream for example file output stream
        OutputStream outputStream = new ByteArrayOutputStream();
        Source xmlSource = new DOMSource(doc);
        Result outputTarget = new StreamResult(outputStream);
        TransformerFactory.newInstance().newTransformer()
          .transform(xmlSource, outputTarget);
//when you replace output stream with file output stream remove this, as this line is only for debugging 
        System.out.println(new String(((ByteArrayOutputStream) outputStream).toByteArray()));