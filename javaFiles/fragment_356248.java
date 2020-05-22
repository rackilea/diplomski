import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.AnnotatedGenericBeanDefinition;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import static java.util.Collections.unmodifiableMap;

/**
 * This is hack to collect all beans of some type in single map without eager initialization of those beans
 *
 * Usage:
 * 1. Register new bean of type {@link ServiceTrackingBeanPostProcessor} parametrized with class of
 *    beans you want to collect
 * 2. Now you can inject {@link ServiceTracker} parametrized with your type anywhere
 *
 * @param <T> Located type
 */
public class ServiceTrackingBeanPostProcessor<T> implements BeanPostProcessor, BeanDefinitionRegistryPostProcessor {
    private final ConcurrentMap<String, T> registeredBeans = new ConcurrentHashMap<>();
    private final Class<T> clazz;
    private final String beanName;

    public ServiceTrackingBeanPostProcessor(Class<T> clazz) {
        this.clazz = clazz;
        beanName = "locatorFor" + clazz.getCanonicalName().replace('.', '_');
    }

    @Override
    public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {
        return o;
    }

    @Override
    public Object postProcessAfterInitialization(Object o, String s) throws BeansException {
        if (!clazz.isInstance(o)) {
            return o;
        }
        registeredBeans.putIfAbsent(s, (T) o);
        return o;
    }

    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        AnnotatedGenericBeanDefinition def = new AnnotatedGenericBeanDefinition(Wrapper.class);
        registry.registerBeanDefinition(beanName, def);
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        beanFactory.registerSingleton(beanName, new Wrapper(unmodifiableMap(registeredBeans)));
    }

    private class Wrapper extends AbstractServiceTracker<T> {
        public Wrapper(Map<String, T> services) {
            super(services);
        }
    }
}