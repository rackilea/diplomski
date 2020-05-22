public class TestFileSearch {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new TestFileSearch();
    }

    public TestFileSearch() {
        File parentPath = new File("C:/Users/shane/Documents");
        List<String> files = list(parentPath);

        for (String file : files) {
            System.out.println(file);
        }
    }

    protected List<String> list(File parent) {
        return listFiles(parent, parent);
    }

    protected List<String> listFiles(File parent, File folder) {
        List<String> lstFiles = new ArrayList<String>(25);
        if (folder.isDirectory()) {

            File[] files = folder.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isDirectory()) {
                        lstFiles.addAll(listFiles(parent, file));
                    } else {
                        String path = file.getPath();
                        String offset = parent.getPath();

                        path = path.substring(offset.length());
                        lstFiles.add(path);
                    }
                }
            }
        }

        return lstFiles;
    }
}