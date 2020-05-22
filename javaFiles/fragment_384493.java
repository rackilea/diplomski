@Component
public class AppContext implements ApplicationContextAware {
    private static MangaDao mangaDao = null;
    public static MangaDao getMangaDao() {
        if(mangaDao == null){
            throw new ApplicationContextException("context not initialized");
        }
        return mangaDao;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        mangaDao = applicationContext.getBean(MangaDao.class);
    }
}