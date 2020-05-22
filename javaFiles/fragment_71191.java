public class zipFIle {

  private final List<String> fileList;

  zipFIle() {
    fileList = new ArrayList<String>();
  }

  private void generateFileList(File file) {
    // whatever...
  }

  public static void main(String[] args) {
    zipFIle appZip = new zipFIle();
    appZip.generateFileList(new File(SOURCE_FOLDER));
    appZip.zipIt(OUTPUT_ZIP_FILE);
  }
}