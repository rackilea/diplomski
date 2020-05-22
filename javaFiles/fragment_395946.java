@Configuration
public class MyConfig extends WebMvcConfigurationSupport {
   @Override
   public FormattingConversionService mvcConversionService() {
       FormattingConversionService f = super.mvcConversionService();
       f.addConverter(new MyCustomEnumConverter());
       return f;
   }
}