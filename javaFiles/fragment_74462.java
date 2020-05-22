@SpringBootApplication
public class SpringBootSecurityInMemoryApplication implements CommandLineRunner {

     @Autowired AuthenticationManager authenticationManager;

................................
...............................
public static void main(String[] args) {
        SpringApplication.run(SpringBootSecurityInMemoryApplication.class, args);
    }

@Override
    public void run(String... args) throws Exception {      
        introspectBean(authenticationManager);


    }

public void printUsersMap(Object bean){

        Field field = ReflectionUtils.findField(org.springframework.security.authentication.ProviderManager.class, "providers");
        ReflectionUtils.makeAccessible(field);
        List listOfProviders = (List)ReflectionUtils.getField(field, bean);     
        DaoAuthenticationProvider dao = (DaoAuthenticationProvider)listOfProviders.get(0);
        Field fieldUserDetailService = ReflectionUtils.findField(DaoAuthenticationProvider.class, "userDetailsService");
        ReflectionUtils.makeAccessible(fieldUserDetailService);
        InMemoryUserDetailsManager userDet = (InMemoryUserDetailsManager)(ReflectionUtils.getField(fieldUserDetailService, dao));
        Field usersMapField = ReflectionUtils.findField(InMemoryUserDetailsManager.class, "users");
        ReflectionUtils.makeAccessible(usersMapField);
        Map map = (Map)ReflectionUtils.getField(usersMapField, userDet);
        System.out.println(map);

    }