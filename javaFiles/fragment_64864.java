public void execute4() {
    File filePath = new File(filePathData);
    File[] files = filePath.listFiles((File data, String name) -> 
             data.getName().endsWith("CDR")); // fixed this line: it had compilation error
    List<CDR> cdrs = Arrays.stream(files).parallel()
            .map(this::readCDRP).sorted(cdrsorter)
            .collect(Collectors.toList());
}

private CDR readCDRP(File file) {
    try (BufferedReader bfr = new BufferedReader(new FileReader(file))) {
        // I'm not sure that collecting lines into list 
        // before main processing was actually necessary
        return bfr.lines().parallelStream()
                .map(e -> new CDREntry(file.getName(), e.split(",", -1)))
                .collect(Collectors.collectingAndThen(
                        Collectors.toList(), list -> new CDR(file.getName(), list)));
    } catch (IOException e) {
        throw new UncheckedIOException(e);
    }
}