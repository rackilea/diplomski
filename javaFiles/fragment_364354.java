@Service
public class CacheScheduler {
    @Autowired
    BookDao bookDao;
    @Autowired
    CacheManager cacheManager;

    @PostConstruct
    public void init() {
        update();
        scheduleUpdateAsync();
    }

    public void update() {
        for (Book book : bookDao.findAll()) {
            cacheManager.getCache("books").put(book.getIsbn(), book);
        }
    }
}