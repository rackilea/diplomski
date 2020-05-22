public class AssignRoles implements UserDetailsService { 

    Public Principal principalObject;
    //getter setter

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException, DataAccessException { 
            List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
            //Access DB and get the roles and assign
            grantedAuthorities.add( new SimpleGrantedAuthority("Role_User"));

            boolean enabled = true;  
            boolean accountNonExpired = true;  
            boolean credentialsNonExpired = true;  
            boolean accountNonLocked = true;   
            UserDetails userDetails =  new User(userName,password,enabled,accountNonExpired, credentialsNonExpired,accountNonLocked,grantedAuthorities); 

           /**ADDING ROLES-Creating authentication object with roles**/
            Authentication authentication = new UserAuthenticationToken(principalObject, userDetails, userDetails.getAuthorities());
            //Set the authentication 
            SecurityContextHolder.getContext().setAuthentication(authentication);  //Authentication is assigned,Now check security context user will have roles
            return userDetails;
    }

}