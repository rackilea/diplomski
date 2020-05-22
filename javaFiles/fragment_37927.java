public class Example {
  // inject the actual template 
  @Autowired
  private RedisTemplate<String, Object> template;

  public void addLink(String userId, URL url) {
    template.opsForList().leftPush(userId, url.toExternalForm());
  }
}