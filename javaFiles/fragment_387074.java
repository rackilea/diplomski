public static String serializeDoc(Node doc) {
        StringWriter outText = new StringWriter();
        StreamResult sr = new StreamResult(outText);
        Properties oprops = new Properties();
        oprops.put(OutputKeys.METHOD, "xml");
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer t = null;
        try {
            t = tf.newTransformer();
            t.setOutputProperties(oprops);
            t.transform(new DOMSource(doc), sr);
        } catch (Exception e) {
            System.out.println(e);
        }
        return outText.toString();
    }