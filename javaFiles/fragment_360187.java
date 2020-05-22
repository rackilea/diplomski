Stream<String> output = Files
        .lines(Paths.get("a.out"))
    List<String> partition = output
        .filter(new StartData())
        .filter(new EndData())
        .collect(toList);
class StartData implements Predicate<String> {

  boolean matchingData = false;

  boolean test(String input) {
    if (input.contains("Input data")) {
      matchingData = true;
    }
    return matchingData;
  }
}
class EndData implements Predicate<String> {

  boolean passThrough = true;

  boolean test(String input) {
    if (input.contains("Another Input")) {
      passThrough = false;
    }
    return passThrough;
  }
}
}