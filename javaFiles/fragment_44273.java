public class DAOModule extends AbstractModule {
    public void configure() {
        bind(FlagDAO.class).to(FlagDAOEbean.class);
        bind(SomethingUsingFlagDAOInterface.class).to(SomethingUsingFlagDAO.class);
    }
}