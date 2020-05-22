import de.professional_webworkx.crm.domain.Person;
import java.util.List;


public interface IDateBroker {

    public abstract void saveOrUpdate(Person person);
    public abstract List<Person> getAllPersons();
    public abstract Person getPersonById(int id);
    public abstract Person getPersonByEmail(String email);
}