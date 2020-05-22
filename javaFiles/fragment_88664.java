import de.professional_webworkx.crm.domain.Person;
import java.util.List;


public interface IPersonService {

    void saveOrUpdate(Person person);
    List<Person> getAllPersons();
    Person getPersonById(int id);
    Person getPersonByEmail(String email);
}