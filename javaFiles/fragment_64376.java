@Before
@Transactional // separate transaction for setUp
public void setUp() {        
    //Avant tout mettre tout les sms en lu 
    smsDao.deleteAllSms(1);
    sessionFactory.getCurrentSession().flush();

    //On vérifie bien qu'il n y a plus de sms
    List<SmsBean> list = smsDao.getNewSmsList(1);
    assertEquals(0,list.size());
}

@Test
@Transactional(propagation = NEVER) // Disable main transaction
public void checkLanguagePreferenceTest() throws InterruptedException, ExecutionException {

    // Programmatic transaction for test preparation
    User user = tx.execute(new TransactionCallback<User>() {
        public User doInTransaction(TransactionStatus status) {
            User user = (User) sessionFactory.getCurrentSession().load(User.class, new Long(1));//idUser = 1
            // We explicitly blank the preference from db
            prefsDao.saveLanguagePref(new UserPrefs("",user));    
            return user;
        }
    });

    Future<UserPrefs> prefs = messagingService.checkLanguagePreference(user.getId()); 
    System.out.println("wait completion of async task");            
    prefs.get();
    System.out.println("Async task has finished");
}

private TransactionTemplate tx;

@Autowired
public void setPtm(PlatformTransactionManager ptm) {
    tx = new TransactionTemplate(ptm);
}