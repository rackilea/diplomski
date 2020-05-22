public class GenericListParser<TParser extends Parsable<T>> extends Parsable<List<T>> {
  private TParser tp = null;
  public GenericListParser(TParser parser) {
      this.tp = parser;
  }
  List<T> parse(String s) {
    String[] strings = s.split(",");
    List<T> result;
    for (String s : strings) {
      result.add(tp.parse(s));
    }
    return result;
  }
}