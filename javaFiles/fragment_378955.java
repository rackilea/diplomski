public class DirectoryReader {
    public static void main(String[] args) {
        readDirectory();
    }

    public static void readDirectory() {
        String root = System.getProperty("user.home") + "\\AppData\\Roaming\\Mozilla\\Firefox\\Profiles\\";
        File file = traverseFolder(new File(root));
        String fileName = file.getName(); // if you want to get the directory name
    }

    public static File traverseFolder(File root) {
        if (root.isDirectory()) {
            File[] files = root.listFiles();
            if (root == null) {
                return null;
            }

            for (File f : files) {
                String fileName = f.getName();
                if (fileName.matches(".*default.*")) {
                    System.out.println(fileName);
                   return f;
               }
           }
        }

        return null;
    }
}