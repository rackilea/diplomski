import de.professional_webworkx.crm.databroker.DataBroker;
import de.professional_webworkx.crm.databroker.IDateBroker;
import de.professional_webworkx.crm.domain.Person;
import java.util.List;


public class PersonService implements IPersonService {

    private IDateBroker broker;

    public PersonService() {
        broker = new DataBroker();
    }

    @Override
    public void saveOrUpdate(Person person) {
        broker.saveOrUpdate(person);
    }

    @Override
    public List<Person> getAllPersons() {
        return broker.getAllPersons();
    }

    @Override
    public Person getPersonById(int id) {
        return broker.getPersonById(id);
    }

    @Override
    public Person getPersonByEmail(String email) {
        return broker.getPersonByEmail(email);
    }
}