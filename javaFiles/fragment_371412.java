ObjectMapper om = new ObjectMapper();
om.enableDefaultTypingAsProperty(DefaultTyping.OBJECT_AND_NON_CONCRETE, "__class");

IPerson value = new MyPerson();
String s = om.writeValueAsString(value);
IPerson d = om.readValue(s, IPerson.class);