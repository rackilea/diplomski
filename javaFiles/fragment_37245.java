Iterable<String> splitted = Splitter.on(',')
    .omitEmptyStrings()
    .trimResults()
    .split("one,two,,   ,three");

for (String text : splitted) {
  System.out.println(text);
}