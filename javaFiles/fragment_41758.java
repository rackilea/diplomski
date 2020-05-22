class UserServiceImpl {
    private Y y = new y();

    public UserServiceImpl() {
        super();
    }

    public UserServiceImpl( final Y y, final UserDao userDao ) {
        super();
        this.y = y;
        setUserDao(userDao); //Or however you would set this....
    }

    public User xyz() {
        if( y.authenticateUser() ) {
            //code
        }
    }
}