package sample;
// ...
public class CustomSecurityConfigurer<H extends HttpSecurityBuilder<H>>
    extends AbstractHttpConfigurer<CustomSecurityConfigurer<H>, H> {

    @Override
    public void init(H http) { }

    @Override
    public void configure(H http) {
        // add your own filter... for example:
        http.addFilterAfter(new ImportantFilter(), LogoutFilter.class);
    }
}