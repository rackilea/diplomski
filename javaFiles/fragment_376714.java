public static void main(String[] args) {
  ZooKeeper zoo;
  try {
    ZooKeeperConfDTO conf = new ZooKeeperConfDTO("localhost:2182", 5000, null);
    zoo = runZoo(conf);
    String json = new Gson().toJson(conf);
    System.out.println(json); //---->{"connectString":"localhost:2182","sessionTimeout":5000}
  } catch (Exception e) {
    e.printStackTrace();
  }
}

private static ZooKeeper runZoo(ZooKeeperConfDTO conf) throws IOException {
  return new ZooKeeper(conf.connectString, conf.sessionTimeout, conf.watcher);
}