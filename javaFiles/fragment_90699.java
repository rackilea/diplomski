@Configuration
@Import(RetrofitRegistrar.class)
public class RetrofitAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public Retrofit retrofit() {
        return new Retrofit.Builder().build();
    }
}