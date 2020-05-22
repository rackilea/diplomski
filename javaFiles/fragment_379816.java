public class CountrySuggestion implements Suggestion {
  ..snip..
  @Override
  public String getDisplayString() {
    return "<i>" + country.getName() + "</i><img src='icon.png'>";
  }
}