package test;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;

import com.xx.xx.xx.xx.xx.RetryInterceptor;

public class TestBeanFacotryPostProcessor implements BeanDefinitionRegistryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
    }

    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        String[] definitionNames = registry.getBeanDefinitionNames();
        for (int i = 0, j = 0; i < definitionNames.length; i++) {
            Class<?> clazz;
            try {
                clazz = Class.forName(registry.getBeanDefinition(definitionNames[i]).getBeanClassName());
                if (RetryInterceptor.class == clazz && j++ > 0) {
                    registry.removeBeanDefinition(definitionNames[i]);
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}