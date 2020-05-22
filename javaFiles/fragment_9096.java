public abstract class Person{
  ...//your states and methods
  protected void copy(Person copiedPerson){
        copiedPerson.name = this.name;
  }

  public abstract Person getCopyPerson();
}

public class SoftwareEngineer extends Person{

     ....//your states and methods
    @override
     protected void copy( Person copiedPerson ){
          super(copiedPerson);
          copiedPerson.job = this.job;
     }

    @override
    public Person getCopyPerson(){
       Person copyPerson = new SoftwareEngineer();
       copy(copyPerson);
       return copyPerson;
    }

}