String s = "5 a section of five words 3 three words\n"
        + "section 2 short section 7 this section contains a lot\n"
        + "of words";
Reader reader = new StringReader(s);
Stream<List<String>> stream = records(StreamEx.ofLines(reader)
               .flatMap(Pattern.compile("\\s+")::splitAsStream));
stream.forEach(System.out::println);