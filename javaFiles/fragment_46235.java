import static java.util.concurrent.ThreadLocalRandom.current;

String getRandomText(int len, double spaceProb) {
    return new SplittableRandom().ints(len, 'a', 'z'+1).parallel()
      .map(i -> current().nextDouble()<spaceProb ? ' ' : i)
      .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();