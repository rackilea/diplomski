@Name("personManager")
public class PersonManager {

    private @In Person person;

}

<h:inputText value="#{person.name}"/>