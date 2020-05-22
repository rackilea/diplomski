public Person getByAccount(Account account) {   
    URL url = new URL(uri);
    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
    connection.setRequestMethod("POST");
    connection.setRequestProperty("Accept", "application/xml");
    connection.setOutput(true);

    XStream xstream = new XStream();
    xstream.toXML(account, connection.getOutputStream());

    Person person = (Person) xstream.fromXML(connection.getInputStream());   
    connection.disconnect();
    return person;
}