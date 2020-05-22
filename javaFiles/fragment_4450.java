public final class TestXMLCRUD {

    public static void main(String[] args) {
        new TestXMLCRUD();
    }

    public TestXMLCRUD() {

        try {

            Document doc = createNewDocument();
            setRootNode(doc, "ThisIsTheRootNode");

            Element child = addElement(doc, "ThisIsAChildNodeOfRoot");
            addElement(doc, child, "ThisIsAChildNode", "I Have text!");
            System.out.println(save(doc));

        } catch (TransformerConfigurationException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (TransformerException ex) {
            ex.printStackTrace();
        } catch (ParserConfigurationException ex) {
            ex.printStackTrace();
        } catch (DOMException ex) {
            ex.printStackTrace();
        }

    }
    private DocumentBuilder builder;

    public Node getRootNode(Document xmlDoc) {

        Node nRoot = null;

        if (xmlDoc != null) {

            nRoot = xmlDoc.getDocumentElement();

        }

        return nRoot;

    }

    public Document createNewDocument() throws ParserConfigurationException {

        Document doc = getDocumentBuilder().newDocument();
        Element root = doc.createElement("root");
        doc.adoptNode(root);
        doc.appendChild(root);

        return doc;

    }

    public Element setRootNode(Document xmlDoc, String name) {

        removeNode(getRootNode(xmlDoc));
        Element root = xmlDoc.createElement(name);
        xmlDoc.adoptNode(root);
        xmlDoc.appendChild(root);

        return root;


    }

    public Document loadDocument(InputStream is) throws ParserConfigurationException, SAXException, IOException {

        return getDocumentBuilder().parse(is);

    }

    public Document loadDocument(File file) throws ParserConfigurationException, SAXException, IOException {

        return getDocumentBuilder().parse(file);

    }

    public Document loadDocumentFromString(String xml) throws ParserConfigurationException, SAXException, IOException {

        Document doc = null;

        ByteArrayInputStream bais = null;

        //StringReader sr = null;
        //InputSource is = null;
        try {

            bais = new ByteArrayInputStream(xml.getBytes());

            doc = loadDocument(bais);

        } finally {

//            try { sr.close(); } catch (Exception e) { }
            try {
                bais.close();
            } catch (Exception e) {
            }

        }

        return doc;

    }

    protected DocumentBuilder getDocumentBuilder() throws ParserConfigurationException {

        if (builder == null) {

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setNamespaceAware(false); // You might want to change this...
            builder = factory.newDocumentBuilder();

        }

        return builder;

    }

    public Element addElement(Document xmlDoc, String name) {

        Element child = xmlDoc.createElement(name);
        getRootNode(xmlDoc).appendChild(child);

        return child;

    }

    public Node addElement(Document xmlDoc, Node node, String name) {

        Node child = xmlDoc.createElement(name);
        node.appendChild(child);

        return child;

    }

    public Node addElement(Document xmlDoc, Node node, String name, String text) {

        Node child = addElement(xmlDoc, node, name);
        child.setTextContent(text);

        return child;

    }

    public void removeNode(Node parentNode) {

        if (parentNode != null) {

            while (parentNode.hasChildNodes()) {

                removeNode(parentNode.getFirstChild());

            }

            Node parent = parentNode.getParentNode();
            if (parent != null) {

                parent.removeChild(parentNode);

                NodeList childNodes = parent.getChildNodes();
                if (childNodes.getLength() > 0) {

                    List<Node> lstTextNodes = new ArrayList<Node>(childNodes.getLength());
                    for (int index = 0; index < childNodes.getLength(); index++) {

                        Node childNode = childNodes.item(index);
                        if (childNode.getNodeType() == Node.TEXT_NODE) {

                            lstTextNodes.add(childNode);

                        }

                    }

                    for (Node node : lstTextNodes) {

                        removeNode(node);

                    }

                }

            }

        }

    }

    public void save(Document xmlDoc, File fFile) throws TransformerConfigurationException, TransformerException, IOException {

        FileOutputStream fos = null;

        try {

            fos = new FileOutputStream(fFile);
            save(xmlDoc, fos);

            fos.flush();

        } finally {

            try {
                fos.close();
            } catch (Exception e) {
            }

        }

    }

    public void save(Document xmlDoc, OutputStream os) throws TransformerConfigurationException, TransformerException, IOException {

        OutputStreamWriter osw = null;

        try {

            osw = new OutputStreamWriter(os);
            save(xmlDoc, osw);
            osw.flush();

        } finally {

            try {
                osw.close();
            } catch (Exception exp) {
            }

        }

    }

    public String save(Document xmlDoc) throws TransformerConfigurationException, IOException, TransformerException {

        String sValue = null;

        ByteArrayOutputStream baos = null;

        try {

            baos = new ByteArrayOutputStream();
            save(xmlDoc, baos);
            baos.flush();
            sValue = new String(baos.toByteArray());

        } finally {

            try {
                baos.close();
            } catch (Exception exp) {
            }

        }

        return sValue;

    }

    public void save(Document xmlDoc, Writer os) throws TransformerConfigurationException, TransformerException {

        Transformer tf = TransformerFactory.newInstance().newTransformer();
        tf.setOutputProperty(OutputKeys.INDENT, "yes");
        tf.setOutputProperty(OutputKeys.METHOD, "xml");
        tf.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");

        DOMSource domSource = new DOMSource(xmlDoc);
        StreamResult sr = new StreamResult(os);
        tf.transform(domSource, sr);

    }
}