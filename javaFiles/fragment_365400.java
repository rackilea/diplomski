public class HulkHogan { 
  private IPerson person;

  public HulkHogan(IPerson person){
    this.person = person;
  }

  public void doSomething(Contant contact){
    //call your method here
    person.savePerson(contact);
  }
}