import org.apache.axis.EngineConfiguration;
import org.apache.axis.Handler;
import org.apache.axis.deployment.wsdd.WSDDProvider;
import org.apache.axis.deployment.wsdd.WSDDService;

public class WSDDSpringProvider extends WSDDProvider {

    public static final String PROVIDER_NAME = "SPRING";
    public static final String PARAM_SPRING_BEAN_ID = "springBeanId";

    public String getName(){
        return "SPRING";
    }

    public Handler newProviderInstance(WSDDService service, EngineConfiguration registry)
        throws Exception {
        return new SpringProvider(service.getParameter("springBeanId"));
    }

}