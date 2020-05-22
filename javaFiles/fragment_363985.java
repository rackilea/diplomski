@Transactional
@Service("userDetailsService")
public class LoginServiceImpl implements UserDetailsService{

    @Autowired private PersonDAO personDAO;
    @Autowired private Assembler assembler;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException,DataAccessException {
        Person person = personDAO.findPersonByUsername(username.toLowerCase());
            if(person == null) { throw new UsernameNotFoundException("Wrong username or password");}
        return assembler.buildUserFromUserEntity(person);
    }

    public LoginServiceImpl() {
    }
}