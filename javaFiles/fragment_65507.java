@Service("personService") 
public class PersonServiceImpl implements PersonService { 

    @Autowired     
    private PersonDAO personDAO; 
    // Some other code
}