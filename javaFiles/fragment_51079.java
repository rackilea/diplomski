String result = "Hello world."
  .codePoints()
//.parallel()  // uncomment this line for large strings
  .map(c -> c == ' ' ? ' ': '*')
  .collect(StringBuilder::new,
           StringBuilder::appendCodePoint, StringBuilder::append)
  .toString();