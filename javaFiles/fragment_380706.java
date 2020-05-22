import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.context.annotation.Configuration;
    import org.springframework.context.annotation.PropertySource;
    import org.springframework.core.env.Environment;
    import java.util.*;
    import java.util.Map.Entry;
    import org.springframework.core.env.AbstractEnvironment;
    import org.springframework.core.env.MapPropertySource;
    import javax.annotation.PostConstruct;


    @Configuration
    @PropertySource(value = {
            "classpath:config/sample.properties"
            })
    public class PropLoaderUtils {
        @Autowired
        private Environment env;

        private Map<String, String> valueAsKeyMap = new HashMap<String, String>();


        @PostConstruct
        private void setPropertyKeys() {
            Iterator<?> itr = ((AbstractEnvironment) env).getPropertySources().iterator();
            Map<String, Object> map = new HashMap<String, Object>();
            while (itr.hasNext()) {
                org.springframework.core.env.PropertySource propertySource = (org.springframework.core.env.PropertySource) itr.next();
                if (propertySource instanceof MapPropertySource) {
                    map.putAll(((MapPropertySource) propertySource).getSource());
                }
            }

            for (Entry<String, Object> entry : map.entrySet()) {
                valueAsKeyMap.put(entry.getKey(), entry.getValue().toString());

            }

            valueAsKeyMap.entrySet().forEach(entry -> System.out.println("key "+entry.getKey()+" value "+entry.getValue()));;
        }


}