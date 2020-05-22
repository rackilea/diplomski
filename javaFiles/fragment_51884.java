public static void main(String args[]) {
File folder = new File("C:\\userids-20130501");

int fileNameCount = 1;
int contentCounter = 1;
File bigFile = new File("<path>" + fileNameCount + ".txt");
boolean isFileRequired = true;
for (File file : folder.listFiles()) {
    if (file.isFile() && file.getName().endsWith(".txt")) {
        try {
            List<String> content = FileUtils.readLines(file, Charset.forName("UTF-8"));
            contentCounter += content.size();
            if(contentCounter < 10Million) {
                FileUtils.writeLines(bigFile, content, true);
            } else {
                fileNameCount++;
                bigFile = new File("<path>" + fileNameCount + ".txt");
                FileUtils.writeLines(bigFile, content);
                contentCounter = 1;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
  }
}