@Configuration
@EnableWs
@ImportResource("classpath:/applicationContext.xml")
public class WebServiceConfiguration extends WsConfigurerAdapter {

    @Bean
    public ServletRegistrationBean wsServlet(){
        ServletRegistrationBean wsServletBean = new ServletRegistrationBean(new WSSpringServlet(), "/services/*");
        wsServletBean.setLoadOnStartup(1);
        //wsServletBean.setInitParameters(initParameters);
        return wsServletBean;
    }
}