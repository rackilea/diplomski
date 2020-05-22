public boolean checkLogin(){

boolean a = false;
try {
    File inputFile = new File("C:\\Users\\Kavindu\\Documents\\NetBeansProjects\\chatserver2\\xml\\userrecord2.xml");
    DocumentBuilderFactory dbFactory
            = DocumentBuilderFactory.newInstance();
    DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
    Document doc = dBuilder.parse(inputFile);
    NodeList userList = doc.getElementsByTagName("user");
    System.out.println("userlist length :: "+ userList.getLength());
      for (int i = 0; i < userList.getLength(); i++) {
        Node user = userList.item(i);
        Element eElement = (Element) user;
        if (eElement.getElementsByTagName("username").item(0).getTextContent().equals(username) && eElement.getElementsByTagName("password").item(0).getTextContent().equals(password)) {

            a = true;
            break;
        } else {
            a = false;
        }
    }




} catch (Exception ex) {
    System.out.println(ex.getMessage());

}
return a;


}