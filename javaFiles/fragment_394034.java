interface Tile38 {

  @Command("NEARBY ?0 FENCE POINT ?1 ?2")
  List<Object> nearByFence(String key, double lon, double lat);
}

RedisClient client = …
RedisCommandFactory factory = new RedisCommandFactory(client.connect());
Tile38 commands = factory.getCommands(Tile38.class);