public static void main(String[] args) {

        ArrayList<String> list = new ArrayList<>();

        // arguments are your folder and the list you
        // want to add the results
        collectFiles(new File("C:/"), list);

        for (String s : list) {
            System.out.println(s);
        }
    }

    private static void collectFiles(File folder, ArrayList<String> list) {
        // Add the current file/folder to the list
        list.add(folder.getAbsolutePath());

        // If its not a directory return cause we already add it
        if (!folder.isDirectory())
            return;

        // We found a directory so get all the files in it
        File[] listOfFiles = folder.listFiles();

        // In case the above returns null return
        if (listOfFiles == null)
            return;

        // For every file in the list
        for (File f : listOfFiles) {
            // if its a directory do a recursive call 
            if (f.isDirectory()) {
                collectFiles(f, list);
            } else {
                // we found a file so add it to the list
                list.add(f.getAbsolutePath());
            }
        }
    }