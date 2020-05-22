@Service
@Transactional
public class SecurityUserDetailService implements UserDetailsService {

    @Autowired private EmployeeService employeeService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            Employee loggedInEmployee = employeeService.findEmployeeByUsername(username);
            List<GrantedAuthority> authorities = getAuthorities(loggedInEmployee);
            boolean enabled = true;
            boolean accountNonExpired = true;
            boolean credentialsNonExpired = true;
            boolean accountNonLocked = true;
            return new User(
                    loggedInEmployee.getUsername(),
                    loggedInEmployee.getPassword().toLowerCase(),
                    enabled,
                    accountNonExpired,
                    credentialsNonExpired,
                    accountNonLocked,
                    authorities);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static List<GrantedAuthority> getAuthorities(Employee employee) {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        for (Role role : employee.getRoles()) {
            for (Permission permission : role.getPermissions()) {
                authorities.add(new SimpleGrantedAuthority(permission.getName()));
            }
        }
        return authorities;
    }

}