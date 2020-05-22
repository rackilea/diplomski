import org.apache.axis.EngineConfiguration;
import org.apache.axis.EngineConfigurationFactory;
import org.apache.axis.configuration.BasicClientConfig;

public class MyEngineConfigurationFactory implements EngineConfigurationFactory {

    public static EngineConfigurationFactory newFactory(Object param) {
        return new MyEngineConfigurationFactory();
    }

    public EngineConfiguration getClientEngineConfig() {
        BasicClientConfig cfg = new BasicClientConfig();
        cfg.deployTransport("MyTransport", new MyClient());
        return cfg;
    }

    public EngineConfiguration getServerEngineConfig() {
        return null;
    }
}