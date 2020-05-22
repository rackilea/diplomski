StringBuilder allowed=
  IntStream.concat(IntStream.rangeClosed('a', 'z'), IntStream.rangeClosed('A', 'Z'))
    .collect(StringBuilder::new,
             StringBuilder::appendCodePoint, StringBuilder::append);
String randomString=random.ints(16, 0, allowed.length()).map(allowed::charAt)
  .collect(StringBuilder::new,
           StringBuilder::appendCodePoint, StringBuilder::append)
  .toString();