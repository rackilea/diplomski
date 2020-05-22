@EnableWebMvc
@Import(...)
@EnableAsync
@EnableScheduling
@EnableTransactionManagement
@EnableAspectJAutoProxy(proxyTargetClass = true)
@ComponentScan(
        basePackages = {"..."})
@Import({
        ...
})
@PropertySources({
        @PropertySource("..."),
        @PropertySource(
                ignoreResourceNotFound = true,
                value = "...")
})
@EnableWebSecurity
@Configuration
public class TheConfig extends WebSecurityConfigurerAdapter  implements WebMvcConfigurer {
    ...
}