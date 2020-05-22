@Override
public Collection<? extends GrantedAuthority> getAuthorities() {
    List<GrantedAuthority> authorities = new ArrayList<>();
    for(Role role : roles){
        authorities.add(new SimpleGrantedAuthority(role.getRole()))
    }
    return authorities;
}