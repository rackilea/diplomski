public class DefaultDataInstall {

    private static final Logger logger = LoggerFactory.getLogger(DefaultDataInstall.class);
    private ApplicationContext applicationContext;

    public DefaultDataInstall(ApplicationContext applicationContext){
        this.applicationContext = applicationContext;
    }

    public void install() {

        InsertUserRole role = new InsertUserRole();
        role.setUserRoleService(applicationContext.getBean("userRoleServiceImpl"));
        role.insert();
        logger.info("User Role data is installed");

        //other stuff
    }
}