@Configuration
@EnableWebMvc
public class WebConfig extends WebMvcConfigurerAdapter {

    @Bean
    public CurrentUserMethodArgumentResolver userMethodArgumentResolver() {
        return new CurrentUserMethodArgumentResolver() {
            @Override
            protected Object resolveName(String name, MethodParameter parameter, NativeWebRequest request) throws Exception {
                SecurityContext securityContext = SecurityContextHolder.getContext();
                CurrentUser annotation = parameter.getParameterAnnotation(CurrentUser.class);
                boolean anonymousUser = securityContext.getAuthentication() instanceof AnonymousAuthenticationToken;
                if (annotation.required() && anonymousUser) {
                    throw new BadCredentialsException("access is denied");
                }
                return super.resolveName(name, parameter, request);
            }
        };
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> list) {
        list.add(userMethodArgumentResolver());
        super.addArgumentResolvers(list);
}