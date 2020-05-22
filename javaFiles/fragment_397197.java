public static void find(String logPath, String safeFolder) throws FileNotFoundException, IOException {
    ArrayList<File> files = new ArrayList<File>();

    BufferedReader br = new BufferedReader(new FileReader(logPath));
    StringBuilder sb = new StringBuilder();
    String line = null;
    while ((line = br.readLine()) != null) {
        Pattern pattern = Pattern.compile("'[a-zA-Z]:\\\\.+?'");
        Matcher matcher = pattern.matcher(line);
        if (matcher.matches()) {
        }
        if (matcher.find()) {
            files.add(new File(matcher.group()));
            System.out.println("Got a new file! " + files.get(files.size() - 1));
        }
    }

    for (File f : files) {
        // Make sure we get a file indeed
        if (f.exists()) {
            if (!f.renameTo(new File(safeFolder, f.getName()))) {
                System.err.println("Unable to move file! " + f);
            }
        } else {
            System.out.println("I got a wrong file! " + f);
        }
    }
}