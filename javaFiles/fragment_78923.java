import com.sun.jersey.spi.inject.Injectable;
import com.sun.jersey.spi.inject.InjectableProvider;
import com.sun.jersey.api.model.Parameter;

@Provider
public class CustomerInjectableProvider implements 
             InjectableProvider<CustomInjectable, Parameter> {

  // you can use @Context variables, as in any Provider/Resource
  @Context 
  private Request request;

  public ComponentScope getScope() {
    // ComponentScope.Singleton, Request or Undefined
  }

  public Injectable getInjectable(ComponentContext i, 
                                  CustomInjectable annotation, 
                                  Parameter param) {
    Injectable injectable = null;
    if (Customer.getClass().isAssignableFrom(param.getParameterClass()) {
      injectable =  getInjectable();
    }
    return injectable;
  }

  private Injectable getInjectable() {
    return new Injectable<Customer>() {
        public Customer getValue() {
          // parse the customer from request... or session... or whatever...    
        }
     };
  }
}