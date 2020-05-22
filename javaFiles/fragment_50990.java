Map<String, Person> myPersons = new HashMap<String, Person>();

myPersons.add("umer", new Person("umer", 12));
myPersons.add("cedb", new Person("cedb", 13));

String myName = //Capture user input here

String myClassName = myPersons.get(myName).getClass().getCannonicalName();