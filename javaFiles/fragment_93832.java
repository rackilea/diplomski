public class Installation {

    private static String[] preIdents = {"<?xml version = \"1.0\"",
        "<SalesOrderAcknowledgement>", "<HeaderData>", ""};
    private static String postIdent = "</SalesOrderAcknowledgement>";
    public static String searchString = "TODPG201412041625130415";

    public static void main(String args[]) {
        final File folder = new File("Z:/Documents/SO_test/2014");
        preIdents[preIdents.length - 1] = searchString;
        listFilesForFolder(folder);
    }

    public static void listFilesForFolder(final File folder) {

        for (final File fileEntry : folder.listFiles()) {
            findWord(searchString, preIdents, postIdent, fileEntry);

        }
    }

    public static void findWord(String word, String[] pre, String post, File file) {
        try {
            Scanner scanner = new Scanner(file);

            String[] prefix = new String[pre.length];

            int status = 0;
            boolean copy = false;
            int lineNum = 0;
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                lineNum++;
                if (copy) {
                    System.out.println(line);
                    if (line.indexOf(post) > -1) {
                        copy = false;
                        status = 0;
                    }
                } else {
                    int index = line.indexOf(pre[status]);
                    if (index > -1) {
                        // System.err.println("found " + pre[status] + " on line " + lineNum); only for tests
                        prefix[status] = (status == 0) ? line.substring(index) : line;
                        if (++status == pre.length) {
                            prefix[status - 1] = line;
                            copy = true;
                            for (String p : prefix) {
                                System.out.println(p);
                            }
                        }
                    } else {
                        status = 0;
                    }
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}