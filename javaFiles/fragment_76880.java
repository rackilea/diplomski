XStream xstream = new XStream();
xstream.alias("person", Person.class);
xstream.alias("phonenumber", PhoneNumber.class);

Person joe = new Person("Joe", "Walnes");
joe.setPhone(new PhoneNumber(123, "1234-456"));
joe.setFax(new PhoneNumber(123, "9999-999"));

String xml = xstream.toXML(joe);