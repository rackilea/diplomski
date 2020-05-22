public class MyCustomEnumConverter implements Converter<String, SortEnum> {
    @Override
    public SortEnum convert(String source) {
       try {
          return SortEnum.valueOf(source);
       } catch(Exception e) {
          return null; // or SortEnum.asc
       }
    }
}