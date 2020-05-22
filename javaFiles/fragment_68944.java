public class WishServiceImpl implements WishService {

    private final WishRepository wishRepository;

    @Autowired
    public WishServiceImpl(WishRepository wishRepository) {
        this.wishRepository = wishRepository;
    }

    // etc.
}