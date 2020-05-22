import java.lang.reflect.Proxy;
import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.enterprise.inject.Produces;

import com.trinary.security.owasp.proxy.OWASPMethodValidatorProxy;

@Local
public class TestServiceFactory {
    Class<?>[] interfaces = {TestService.class};

    @Produces
    @Default
    public TestService createESignService() throws IllegalArgumentException, InstantiationException, IllegalAccessException {
        return (TestService)Proxy.newProxyInstance(
                this.getClass().getClassLoader(), 
                interfaces,
                new OWASPMethodValidatorProxy<TestService>(TestServiceImpl.class));
    }
}