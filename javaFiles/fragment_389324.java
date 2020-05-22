static String replace(String source)
{// the pattern would be better off being re-usable stored in a static field
  final Pattern pattern = Pattern.compile("://www.", Pattern.LITERAL);
  final Matcher m = pattern.matcher(source);
  boolean result = m.find();
  if (result) {
      StringBuilder sb = new StringBuilder(source.length()+16);
      int p=0;
      do {
        sb.append(source, p, m.start()).append("://www-x1.");
        p=m.end();
      } while (m.find());
      sb.append(source, p, source.length());
      return sb.toString();
  }
  return source;
}