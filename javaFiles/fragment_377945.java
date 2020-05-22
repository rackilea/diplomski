public UserDetails createUserDetails(String name, String password){

    UserDetails ud = UserDetailsUtil.create(CounterLocalServiceUtil.increment());
    ud.setName(name);
    ud.setPassword(password);
    UserDetails newUd = UserDetailsUtil.update(ud);

    return newUd;
}