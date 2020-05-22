class Incrementer {
  Pattern p;
  public Incrementer() {
    p = Pattern.compile("(?:([47]*)([0-6]))?(.*)");
  }
  public String next(String s) {
    Matcher m = p.matcher(s);
    m.lookingAt();
    return (m.group(1)==null
              ? '4'
              : m.group(1) + (m.group(2).charAt(0) >= '4' ? '7' : '4'))
           + m.group(3).replaceAll(".", "4");
  }
}