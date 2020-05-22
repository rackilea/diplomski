public class DAOModule extends AbstractModule {
    public void configure() {
        if(weNeedOracle) {
           bind(FlagDAO.class).to(FlagDAOOracle.class);
        } else {
           bind(FlagDAO.class).to(FlagDAOMysql.class);
        }
    }
}