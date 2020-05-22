@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Value("${server.port}")
    private int serverPort;

    @Value("${security.sslRedirectPort}")
    private int sslRedirectPort;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.[the usual request matchers, authorizeRequests, etc]
            .and()
            .requestCache().requestCache(requestCache());

    }

    private PortMapper portMapper() {
        PortMapperImpl portMapper = new PortMapperImpl();
        Map<String, String> mappings = Maps.newHashMap();
        mappings.put(Integer.toString(serverPort), Integer.toString(sslRedirectPort));
        portMapper.setPortMappings(mappings);
        return portMapper;
    }

    private RequestCache requestCache() {
        HttpSessionRequestCache requestCache = new HttpSessionRequestCache();
        PortResolverImpl portResolver = new PortResolverImpl();
        portResolver.setPortMapper(portMapper());
        requestCache.setPortResolver(portResolver);
        return requestCache;
    }

}