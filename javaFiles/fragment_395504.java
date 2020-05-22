int fromMinute = 1;
int toMinute = 10;

List<String> list = new ArrayList<String>();
for(int i = fromMinute ; i < toMinute ; i++) {
    list.add(i.toString());
}

Jedis jedis = new Jedis("localhost");
List<String> values = jedis.hmget("your_set_name", list);