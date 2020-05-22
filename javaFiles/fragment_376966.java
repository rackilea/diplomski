import org.springframework.format.Formatter;

public class SearchInfoFormatter implements Formatter<SearchInfo> {
  @Override
  public String print(SearchInfo info, Locale locale) {
    // Format SearchInfo into String here.
  }

  @Override
  public SearchInfo parse(String text, Locale locale) {
    // Format String into SearchInfo here.
  }
}