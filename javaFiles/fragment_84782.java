FileInputStream fis = null;

try {
    File f = new File(xmls.get(i));
    File destFile = new File(structDir + "/badXMLs/" + f.getName());
    fis = new FileInputStream(f);

    DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
    DocumentBuilder db = dbf.newDocumentBuilder();
    Document doc = db.parse(fis); // parse the FileInputStream, not the File
    doc.getDoctype();

} catch (Exception e) {
    if (fis != null) {
        fis.close();
    }

    File f = new File(xmls.get(i));
    File destFile = new File(structDir + "/badXMLs/" + f.getName());

    System.out.println(f.getName());
    delete = true;
}