public class PersonService {

    @Inject
    private Injector injector;

    public List<Person> getAllPersons() {
        TypeLiteral<GenericDAO<Person, String>> personDaoTypeLiteral = new TypeLiteral<GenericDAO<Person, String>>() {};
        PersonDao pd = injector.getInstance(Key.get(personDaoTypeLiteral));
        return pd.getAll();
    }
}