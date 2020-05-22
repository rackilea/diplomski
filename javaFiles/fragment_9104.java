@Configuration
public class ConvertersConfig extends WebMvcConfigurerAdapter{

@Override
public void addFormatters(FormatterRegistry registry) {
    registry.addConverter(new AppDataFormConverter());
    super.addFormatters(registry); //To change body of generated methods, choose Tools | Templates.
}

}