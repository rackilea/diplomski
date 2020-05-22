class Person {
  private final String fname;
  private final String lname;

  // Private constructor - must use the static method
  private Person(String first, String last) {fname = first; lname = last;}

  // Note that this is slow - the time it takes is proportional to the length of the
  // two names
  public boolean equals(Object o) {
    // Should check types here, etc.
    Person other = (Person) o;
    if (!person.fname.equals(other.fname)) {return false;}
    if (!person.lname.equals(other.lname)) {return false;}
    return true;
  }

  // Registry of all existing people
  private static Map<String, Person> registry = new TreeMap<String, Person>();

  public static getPerson(String fname, String lname) {
    String fullName = fname + "-" + lname;
    // If we already have this person, return that object, don't construct a new one.
    // This ensures that p1.equals(p2) means that p1 == p2
    if (registry.containsKey(fullName)) {return registry.get(fullName);}
    Person p = new Person(fname, lname);
    registry.put(fullName, p);
    return p;
  }
}