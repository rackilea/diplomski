TableStringBuilder<Person> t = new TableStringBuilder<Person>();
t.addColumn("id", Person::getId);
t.addColumn("first name", Person::getFirstName);
t.addColumn("last name", Person::getLastName);
t.addColumn("height", Person::getHeight);
String s = t.createString(persons);