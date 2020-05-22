@Service
public class CustomUserDetailsService implements UserDetailsService {
 @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userService.findByLogin(username);

        if (!user.isPresent()) {
            Object args[] = {username};
            throw new UsernameNotFoundException(
            messageSource.getMessage("user.notexist", args, "User {0} doesn't not exist", LocaleContextHolder.getLocale())
            );
        }
        if (!user.get().isActivated()) {
            //throw new UserNotActivatedException(String.format("User %s was not activated!", username));
            Object args[] = {username};
            throw new UserNotActivatedException(
                    messageSource.getMessage("user.notactivated", args, "User {0} was not activated", LocaleContextHolder.getLocale()));
        }
        //Here implement your proper logic
        //Add busness logic security Roles
        // eg ROLE_MANAGE_PROJECT:{project_key}, ROLE_MANAGE_CATALOG:{project_key}
        List<Role> bRoles = projectService.getRolesForUser(username)
        user.get().getRoles().addAll(
            bRoles
            );

        UserRepositoryUserDetails userDetails = new UserRepositoryUserDetails(user.get());
        return userDetails;
    }
}