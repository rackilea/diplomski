@Service
@Transactional
public class BootUserService implements  IUserService {

    @Autowired
    private BootSecurityUserDao gpuser_Dao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("............"+username);

        GUser gUser = gpuser_Dao.findUser(username);
  UserDetails userDetails = null;
        if (gUser== null) {
            throw new UsernameNotFoundException("No User found");
        } else {
            List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
            //Access DB and get the roles and assign
            grantedAuthorities.add( new       SimpleGrantedAuthority(gUser.getAuthority())); //If not fetched fetch from db and assign
            //you can add any number of roles like
            /** grantedAuthorities.add( new       SimpleGrantedAuthority("RoleJustAsString")); **/

            userDetails =  new  User(userName,password,enabled,accountNonExpired, credentialsNonExpired,accountNonLocked,grantedAuthorities); 

           /**ADDING ROLES-Creating authentication object with roles**/
            Authentication authentication = new UserAuthenticationToken(gUser, userDetails, userDetails.getAuthorities());
            //Set the authentication 
                   SecurityContextHolder.getContext().setAuthentication(authentication); 
        }
        System.out.println("-=--------------user----"+user.toString());
        return userDetails;

    }
}