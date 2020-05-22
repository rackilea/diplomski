List<Person> personList=new ArrayList<Person>();
while(rs.next())
{               
    personList.add(new Person(rs.getString("fn"),rs.getString("lastName"),...));
}

PersonWrapper pw=new PersonWrapper();
pw.setPersons(personList);

JAXBContext context = JAXBContext.newInstance(PersonWrapper.class);
Marshaller m = context.createMarshaller();
m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

//write to system.out or any other OutputStream (ByteArrayOutputStream)
m.marshal(pw, System.out); 

//OR write to xml file
m.marshal(pw, new File("person.xml"));