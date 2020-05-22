import org.springframework.beans.factory.annotation.Autowired;  
 import org.springframework.boot.actuate.autoconfigure.EndpointAutoConfiguration;  
 import org.springframework.boot.actuate.endpoint.BeansEndpoint;  
 import org.springframework.boot.actuate.endpoint.HealthEndpoint;  
 import org.springframework.boot.actuate.endpoint.InfoEndpoint;  
 import org.springframework.boot.actuate.endpoint.RequestMappingEndpoint;  
 import org.springframework.boot.actuate.endpoint.mvc.EndpointHandlerMapping;  
 import org.springframework.boot.actuate.endpoint.mvc.EndpointMvcAdapter;  
 import org.springframework.boot.actuate.endpoint.mvc.HealthMvcEndpoint;  
 import org.springframework.boot.actuate.endpoint.mvc.MvcEndpoint;  

 @Configuration  
 @Import(EndpointAutoConfiguration.class)  
 public class MyAppSpringConfig {  

   @Bean  
   @Autowired  
   //Define the HandlerMapping similar to RequestHandlerMapping to expose the endpoint  
   public EndpointHandlerMapping endpointHandlerMapping(  
     Collection<? extends MvcEndpoint> endpoints  
   ){  
     return new EndpointHandlerMapping(endpoints);  
   }  

   @Bean  
   @Autowired  
   //define the HealthPoint endpoint  
   public HealthMvcEndpoint healthMvcEndpoint(HealthEndpoint delegate){  
     return new HealthMvcEndpoint(delegate, false);  
   }  

   @Bean  
   @Autowired  
   //define the Info endpoint  
   public EndpointMvcAdapter infoMvcEndPoint(InfoEndpoint delegate){  
      return new EndpointMvcAdapter(delegate);  
   }  

   @Bean  
   @Autowired  
   //define the beans endpoint  
   public EndpointMvcAdapter beansEndPoint(BeansEndpoint delegate){  
     return new EndpointMvcAdapter(delegate);  
   }  

   @Bean  
   @Autowired  
   //define the mappings endpoint  
   public EndpointMvcAdapter requestMappingEndPoint(  
     RequestMappingEndpoint delegate  
   ){  
     return new EndpointMvcAdapter(delegate);  
  }  
}