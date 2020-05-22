@Service
/*These variable names are used for clarity's sake, I don't actually use these names myself*/
public UserServiceImpl implements UserService{
    @Autowired
    private HibernateUserDAO1 userDao1;
    @Autowired
    private HibernateUserDAO2 userDao2

    @Transactional
    /*Put your try catch block around where this method is called*/
    public void saveUserDao1(User user){
         userDao1.saveOrUpdate(user);
    }

    @Transactional
    /*Only call this if saveUserDao1 succeeds*/
    public void saveUserDao2(User user){
          userDao2.saveOrUpdate(user)
    }
}