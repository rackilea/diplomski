@Stateless
@Interceptors(SpringBeanAutowiringInterceptor.class)
public class MyEjb {

   @Autowired
   private ConnectionFactory mqConnectorFactory;

}