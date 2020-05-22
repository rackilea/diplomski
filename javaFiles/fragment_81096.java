public class StartAppFilesProcessorListener implements ApplicationListener<ContextRefreshedEvent> {

  private static final String PATH = System.getProperty("user.dir") + "/src/tmp/dbEnv";

  @Override
  public void onApplicationEvent(ContextRefreshedEvent event) {
    File file = new File(PATH);
    if (!file.exists()) {
      try {
        Files.createDirectories(Paths.get(PATH));
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }
}