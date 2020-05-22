Path dir = Paths.get("d:/Userfiles/arafei/Desktop/pd_files");
Path out = Paths.get("d:/Userfiles/arafei/Desktop/pd_files/output.log");

if(Files.isDirectory(dir)) {
    List<Path> files = Files.list(dir)
        .filter(Files::isRegularFile)
        .collect(Collectors.toList());

    List<String> outLines = new ArrayList<>();
    for(Path p : files) {
        Files.readAllLines(p)
            .stream()
            .filter(line -> 
                line.toLowerCase().contains("password")
                && !line.toLowerCase().contains("password *")
                && !line.toLowerCase().contains("password none")
            )
            .forEach(outLines::add);
    }
    Files.write(out, outLines);
}