import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner

// add these 2 lines and change your impelentation to ApplicationRunner
@Component
@Order(value = 1)
public class ServiceImplement implements ApplicationRunner{
    @Autowired
    UserService userService;
    @Autowired
    UserRepository userRepository; 
    @Autowired
    RoleRepository roleRepository;

    //$2y$12$YN6IjSzj5DYvSpv6jofxV.p8C.zSKKTdnDZ4oc0XT0TmODcUe.s62  =  umut1234

    User umut = null;
    Role userRole = null;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        umut = new User();
        umut.setEmail("umut@umut.com");
        umut.setPassword("$2y$12$YN6IjSzj5DYvSpv6jofxV.p8C.zSKKTdnDZ4oc0XT0TmODcUe.s62");
        umut.setName("Umut");
        umut.setLastName("Eren");
        umut.setActive(1);
//save user before add roles to it
        userRepository.save(umut);
        userRole = roleRepository.findByRole("ADMIN");
        umut.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
        userRepository.save(umut);

        System.out.println("***Generated***");
    }
}