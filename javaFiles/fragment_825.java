import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class VoterBean implements Serializable{

     private Person person = new Person();
     private List<Person> personsList = new ArrayList<Person>();

     public VoterBean(){
     }

     public List<Person> getPersonsList() {
          return personsList;
     }

     public String saveRegistration(){
         personsList.add(person);
         return "registrationsList";  // navigation to the registration list page after each complete registration process (click save button)
     }

}