String[] array = {"Name", "Age", "Contact", "Location"};
List<String> list = Arrays.asList(array);
sc.textFile("...")
    .map(x -> Arrays.asList(x.split("\n")))
    .map(x -> list.stream()
                  .map(col -> x.stream()
                               .filter(line -> line.startsWith(col))
                               .findAny()
                               .orElse(col+" :"))
                  .collect(Collectors.toList()) );