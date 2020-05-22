public class MyGrantedAuthority extends GrantedAuthority{

}

public class UserDetailsImpl implements UserDetails {

    private Collection<MyGrantedAuthority> authorities = new  ArrayList<>();

    @Override
    public Collection<MyGrantedAuthority> getAuthorities() {
        return authorities;
    }
}


UserDetailsImpl u = new UserDetailsImpl();
u.getAuthorities().add(new MyGrantedAuthority());