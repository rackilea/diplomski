List<List<String>> dumpedThreads = new ArrayList<>();
try (FileReader fr = new FileReader("path/to/thread-dump.txt")) {
    try (BufferedReader br = new BufferedReader(fr)) {
        List<String> thisThread = null;
        for (String line = br.readLine(); line != null; line = br.readLine()) {
            if (line.trim().length() == 0) {
                thisThread = null;
            } else {
                if (thisThread == null) {
                    thisThread = new ArrayList<>();
                    dumpedThreads.add(thisThread);
                }
                thisThread.add(line);
            }
        }
    }
}