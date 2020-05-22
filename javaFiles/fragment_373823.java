public Person readPerson(String uNummer) {
    System.out.println("read person");
    Person person = new Person(); //if there is an error during deserialization, this is going to be returned, is this what you want?
    try{
        File xmlFile = new File(file_path + uNummer + ".xml");
        person = (Person) xstream.fromXML(xmlFile);       
    }catch(Exception e){
        System.err.println("Error in XML Read: " + e.getMessage());
    }
    return person;
}