try {
    DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
    DocumentBuilder db = dbf.newDocumentBuilder();
    File xml = new File("file.xml");
    Document document = db.parse(xml);

     // Create a new context...
    JAXBContext jc = JAXBContext.newInstance(Students.class);

    // Create a new Binder from the context
    Binder<Node> binder = jc.createBinder();
    // Load the document
    Students students = (Students) binder.unmarshal(document);

    // Update the student at position 0
    Student student = students.get(0);
    student.setAge(100);

    // Add a new student
    students.add(new Student(200, "Harry", 65));

    // Update the document
    binder.updateXML(students);

    // Write the contents back to the file..
    FileOutputStream fos = null;
    try {
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer t = tf.newTransformer();
        fos = new FileOutputStream(xml);
        t.transform(new DOMSource(document), new StreamResult(fos));
    } catch (TransformerFactoryConfigurationError | TransformerException exp) {
        exp.printStackTrace();
    } finally {
        try {
            fos.close();
        } catch (Exception e) {
        }
    }
} catch (ParserConfigurationException | SAXException | IOException | JAXBException exp) {
    exp.printStackTrace();
}