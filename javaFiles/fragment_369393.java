String prefix = "...proper divisors: ";
// Same number of chars as prefix, just all spaces.
String emptyPrefix = prefix.replaceAll(".", " ");
for (int i = 0; i < properDivisors.length;) {

  // Take as many of the items in the array as you can, without exceeding the
  // max line length.
  StringBuilder sb = new StringBuilder(prefix);
  for (; i < properDivisors.length; ++i) {
    int lengthBefore = sb.length();

    // Append the next item, and comma, if it would be needed.
    sb.append(properDivisors[i]);
    if (i + 1 < properDivisors.length) sb.append(",");

    if (sb.length() > maxWidth) {
      // Truncate back to the length before appending.
      sb.setLength(lengthBefore);
      break;
    }
  }
  System.out.println(sb);

  // Blank out the prefix, so you will print leading spaces on next line.
  prefix = emptyPrefix;
}