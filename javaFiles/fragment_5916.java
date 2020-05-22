@Autowired
private ApplicationContext applicationContext;

@Override
public void addInterceptors(InterceptorRegistry registry) {
    Map<String, CustomInterceptor> interceptors = applicationContext.getBeansOfType(CustomInterceptor.class);
    for(CustomInterceptor interceptor : interceptors.values()){
          registry.addInterceptor(interceptor);
    }
}