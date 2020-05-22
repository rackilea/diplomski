@Configuration
@EnableWebMvc   // this annotation imports the class  WebMvcConfigurationSupport which bootstraps web mvc
@ComponentScan(basePackages = { "com.orgname"  })
public class WebConfig extends WebMvcConfigurerAdapter {

@Bean
public ViewResolver viewResolver() {

    InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
    viewResolver.setViewClass(JstlView.class);
    viewResolver.setPrefix("/view/jsp/");
    viewResolver.setSuffix(".jsp");
    return viewResolver;
}

@Override
public void addResourceHandlers(ResourceHandlerRegistry registry) {
    registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
}

/**
 * This method invocation bean stands for the method call:
 * CookieHandler.setDefault(new CookieManager());
 * which should be done at the beginning of an HTTP session to bootstrap
 * the Java 6 Http state management mechanism for the application as a whole. 
 * (http://docs.oracle.com/javase/tutorial/networking/cookies/cookiehandler.html)
 * 
 */
@Bean(name="cookieHandlerSetDefaultBean") 
public MethodInvokingFactoryBean methodInvokingFactoryBean() { 
    MethodInvokingFactoryBean methodInvokingFactoryBean = new MethodInvokingFactoryBean();
    methodInvokingFactoryBean.setTargetClass(CookieHandler.class);
    methodInvokingFactoryBean.setTargetMethod("setDefault");
    CookieManager cookieManager = new CookieManager();
    methodInvokingFactoryBean.setArguments(new Object[]{cookieManager}); 
    return methodInvokingFactoryBean; 
}
}