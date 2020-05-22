public class RedisExample {
    // Just use the RedisTemplate - don't inject the ListOperations
    private final RedisTemplate<String, String> redisTemplate;

    // Use constructor injection (preferred over field injection)
    @Autowired
    public RedisExample(final RedisTemplate<String, String> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public void addLink(String userId, URL url) {
        // Here is the trick:
        // You can either retrieve the ListOperations this way
        ListOperations<String, String> listOps = redisTemplate.opsForList();
        listOps.leftPush(userId, url.toExternalForm());

        // or, you can retrieve it this way
        redisTemplate.boundListOps(userId).leftPush(url.toExternalForm());
    }
}