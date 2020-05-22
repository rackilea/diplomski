Student s = new Student("Mike", "Tyson");
Student s1 = new Student("Mike", "Wilson");
City c = new City("London");
s.setCity(c);
s1.setCity(c);
session.save(c);
session.save(s);
session.save(s1);