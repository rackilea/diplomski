@Autowired
    public LoginServiceImpl(@Qualifier("authenticationManager") AuthenticationManager authenticationManager, UserDao userDao,
            UserPreferenceDao userPreferenceDao) {
        this.authenticationManager = authenticationManager;
        this.userDao = userDao;
        this.userPreferenceDao = userPreferenceDao;
    }