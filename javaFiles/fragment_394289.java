@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = DemoApplication.class)
public class DemoApplicationTests {

    @Autowired
    private RedisTemplate<String, String> template;

    @Test
    public void contextLoads() {

        template.getConnectionFactory().getConnection().flushAll();

        assertFalse(template.hasKey("key"));
        assertFalse(template.expire("key", 10, TimeUnit.MINUTES));
        assertEquals(0, template.getExpire("key", TimeUnit.MINUTES).longValue());

        template.opsForHash().put("key", "hashkey", "hashvalue");

        assertTrue(template.hasKey("key"));
        assertTrue(template.expire("key", 10, TimeUnit.MINUTES));
        assertTrue(template.getExpire("key", TimeUnit.MINUTES) > 8);
    }

}