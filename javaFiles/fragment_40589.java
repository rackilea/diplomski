@Configuration
@EnableWebMvc
public class YourConfiguration extends WebMvcConfigurerAdapter {
    @Override
        public void configureMessageConverters(
                List<HttpMessageConverter<?>> converters) {

            // Do your magic, override your stuff
        }
}