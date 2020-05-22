@Override
    public User map(BaseUserDto baseUser) {
        if ( baseUser == null ) {
            return null;
        }

        User user = userMapperResolver.resolve( baseUser, User.class );

        user.setId( baseUser.getId() );
        user.setSocialMediaProvider( baseUser.getSocialMediaProvider() );
...
}