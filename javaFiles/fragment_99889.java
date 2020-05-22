public class PersonData {

  private final Map<Integer,PersonType> map;

  public PersonData() {  //constructor
    map = new HashMap<>();
    map.put( 1, new PersonType(1, 'x', 23));
    map.put( 2, new PersonType(2, 'y', 28));
    map.put( 3, new PersonType(3, 'z', 37));
 }