@OnApplicationStart
public class Bootstrap extends Job {

  public void doJob() {
    if (Play.mode == Play.Mode.DEV) {
        DropboxFolder.deleteAll(); // delete 
        Fixtures.load("samples_data.yml"); // recreate 
    }
  }
}