Set<String> lines1 = 
    new HashSet<>(Files.readLines(new File("1.txt"), Charsets.UTF_8));
Set<String> lines2 = 
    new HashSet<>(Files.readLines(new File("2.txt"), Charsets.UTF_8));
Set<String> minus1 = Sets.difference(lines1, lines2);
Set<String> minus2 = Sets.difference(lines2, lines1);
Files.asCharSink(new File("3.txt"), Charsets.UTF_8).writeLines(minus1);
Files.asCharSink(new File("4.txt"), Charsets.UTF_8).writeLines(minus2);