public class ManagePerson<T extends MinimalPerson> {

  private List<T> persons;

    public ManagePerson(List<T> persons) {
       this.persons = persons;
    }

    public List<T> getPersons() {
       return persons;   

    }

}