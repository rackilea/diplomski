private PropertyMap<ActiveDirectoryUser, User> createUserMap = new PropertyMap<ActiveDirectoryUser, User>() {
    protected void configure() {
        using(myConverter).map(source.getGroupMembership()).setAdmin(false);
        map(source.getCn(), destination.getFullName());
        map(source.getsAMAccountName(), destination.getLoginName());
        map(source.getMail(), destination.getEmail());
        map(source.isEnabled(), destination.isActive());
    };
};