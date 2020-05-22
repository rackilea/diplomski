public void outPutInformation() throws FileNotFoundException, UnsupportedEncodingException {

    String filename = user1.getText();
    String firstname = fname1.getText();
    String middlename = Mname1.getText();
    String lastname = Lname1.getText();
    String username = user1.getText();
    @SuppressWarnings("deprecation")
    String password = pass1.getText();
    String hotmail = email1.getText();
    String secretcode = scode1.getText();

    PrintWriter writer = new PrintWriter(filename+".txt", "UTF-8");
    writer.println(firstname);
    writer.println(middlename);
    writer.println(lastname);
    writer.println(username);
    writer.println(password);
    writer.println(hotmail);
    writer.println(secretcode);
    writer.close();
}