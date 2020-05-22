@Override
    public UserDetails loadUserByUsername(String userInfo)
            throws UsernameNotFoundException {
        // use userInfo to check user Info then return object from UserDetails class
    String[] tokens=userInfo.split("@0@");
    Collection<GrantedAuthority> authorities= new ArrayList<GrantedAuthority>();
    // here you pass the Role so you can use later in your application
    authorities.add(new SimpleGrantedAuthority ("ROLE_"+tokens[2]));
    UserDetails userDetails = new User(tokens[0],tokens[1], authorities);
    return userDetails;
}