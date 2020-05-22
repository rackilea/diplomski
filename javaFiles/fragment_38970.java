public void process(Path path){
    StreamEx.of(Files.lines(path))
        .groupRuns((line1, line2) -> line2.charAt(0) == ' ')
        // Now Stream elements are List<String> starting with MASTER and having
        // all subref strings after that
        .map(record -> {
           MyBuilder builder = new MyBuilder();
           builder.parseMasterRef(record.get(0));
           record.subList(1, record.size()).forEach(builder::parseSubRef);
           return record.build();
        })
        //eliminate null
        .filter(Objects::nonNull)
        //some processing on results
        .map(Utils::doSomething)
        //terminal op
        .forEach(System.out::println);
}