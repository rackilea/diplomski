public class Converter extends DozerConverter<List<B>, List<B>> {
  public Converter() {
    super(List.class, List.class);
  }

  public List<B> convertTo(List<B> source, List<B> destination) {
    List<B> result = new ArrayList<B>();
    for (B item : source) {
      if (item != null) {
          result.add(item); //or item copy, or whatever you want
      }
    }
    return result;
  }
}