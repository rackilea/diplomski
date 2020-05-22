@Configuration
@EnableWebFlux
class WebConfig: WebFluxConfigurer
{
    override fun addCorsMappings(registry: CorsRegistry)
    {
        registry.addMapping("/**")
            .allowedOrigins("*") // any host or put domain(s) here
            .allowedMethods("GET, POST") // put the http verbs you want allow
            .allowedHeaders("Authorization") // put the http headers you want allow
    }
}