@Service("customUserDetailsServiceImplBean")
public class CustomUserDetailsServiceImpl implements CustomUserDetailsService {
...
}

CustomUserDetailsService userService = (CustomUserDetailsService) SpringApplicationContext.getBean("customUserDetailsServiceImplBean");