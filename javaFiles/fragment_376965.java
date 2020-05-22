import org.springframework.format.FormatterRegistrar;
import org.springframework.format.FormatterRegistry;

public class SearchInfoFormatterRegistrar implements FormatterRegistrar {
  @Override
  public void registerFormatters(FormatterRegistry registry) {
    registry.addFormatterForFieldType(SearchInfo.class, new SearchInfoFormatter());
  }
}