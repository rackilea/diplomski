public class TestJedis {

    public static void main(String[] args) {
        JedisPool pool = new JedisPool(new JedisPoolConfig(), "localhost");

        Jedis jedis = pool.getResource();
        jedis.set("notify", "umq");
        jedis.expire("notify", 10);

    }
}