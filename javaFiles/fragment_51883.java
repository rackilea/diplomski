public static void main(String args[]) {

File folder = new File("C:\\userids-20130501");

Set<String> userIdSet = new LinkedHashSet<String>();
int count = 1;
for (File file : folder.listFiles()) {
    if (file.isFile() && file.getName().endsWith(".txt")) {
        try {
            List<String> content = FileUtils.readLines(file, Charset.forName("UTF-8"));
            userIdSet.addAll(content);
            if(userIdSet.size() >= 10Million) {
                File bigFile = new File("<path>" + count + ".txt");
                FileUtils.writeLines(bigFile, userIdSet);
                count++;
                userIdSet = new LinkedHashSet<String>(); 
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
  }
}