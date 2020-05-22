import java.util.*;

class Creator{

  private Map<String, Subject> map = new HashMap<String, Subject>();

  public void addSubject(String subjName) {
     map.put( subjName, new Subject(subjName) );
  }

  public Subject getSubject(String subjName) {
     return map.get(subjName);
  }
}

class Subject {
  private String name;
    public Subject(String newName) {
      name = newName;
    }
    @Override
    public String toString() {
      return name;
    }
}

// using...
Creator method = new Creator();
method.addSubject("example");

// prints example
System.out.println( method.getSubject("example") );

// prints null, since there is not a value associeted to the "foo" 
// key in the map. the map key is your "instance name".
System.out.println( method.getSubject("foo") );