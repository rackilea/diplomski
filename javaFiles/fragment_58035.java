public void readCSVFile() {
    // exception handling ignored for space
    br = new BufferedReader(new FileReader(getFileName()));
    List<Future<String>> futures = new ArrayList<Future<String>>();
    ExecutorService pool = Executors.newFixedThreadPool(5);

    while ((line = br.readLine()) != null) {
        final String[] splitLine = line.split(cvsSplitBy);
        futures.add(pool.submit(new Callable<String> {
            public String call() {
                long searchCount = getSearchCount(splitLine[2]);
                return new StringBuilder()
                    .append(splitLine[0]+ ",")
                    .append(splitLine[1]+ ",")
                    .append(searchCount + ",")
                    .toString();
            }
        }));
    }

    for (Future<String> fs: futures) {
        writeToFile(fs.get(), getNewFileName());
    }

    pool.shutdown();
}