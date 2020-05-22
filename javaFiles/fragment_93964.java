@XmlRootElement(name = "Person")
public class Person{
   private String firstName;
   private String lastName;
   private String idName;

  ....
}

@XmlRootElement(name = "PersonWrapper")
public class PersonWrapper{
   private List<Person> persons;

   @XmlElementWrapper(name = "PersonList")
   @XmlElement(name = "Person")
   public List getPersons(){
      return persons;
   }
   ....
}