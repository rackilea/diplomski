//MySpring user is just a class that extends from 
   //org.springframework.security.core.userdetails.User
   //org...security....User implements UserDetailsService that is the 
   //the reason why I can return this class from loadUserByUsername method, you will see it later
   //it helps me to wrap my own User definition
   public class MySpringUser  extends User {

    //this is my own user definition, where all my custom fields are defined
    private MyUser user;

    //the constructor expect for myUser and then I call the super
    //constructor to fill the basic fields that are mandatory for spring 
    //security in order to perform the authentication process
    public MySpringUser(MyUser myUser, Collection<? extends GrantedAuthority> authorities) {
        super(myUser.getUsername(), myUser.getPassword(), myUser.isEnabled()
                , true, true, true, authorities);

        this.setUser(myUser);
    }

    public MyUser getUser() {
        return user;
    }

    public void setUser(MyUser user) {
        this.user = user;
    }
    //this is an example of how to get custom fields a custom id for example
    public Long getId(){
        return this.getUser().getId();
    }
}