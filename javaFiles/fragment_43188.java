import org.springframework.beans.BeansException;
import org.springframework.beans.factory.support.MergedBeanDefinitionPostProcessor;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.stereotype.Component;


@Component
public class MyBeanPostProcessor implements MergedBeanDefinitionPostProcessor {


    @Override
    public void postProcessMergedBeanDefinition(RootBeanDefinition beanDefinition, Class<?> beanType, String beanName) {
        if(beanName.equals("myBeanFirst")) {
            beanDefinition.getPropertyValues().add("a", getMyBeanFirstAImpl());
        }
        else if(beanName.equals("myBeanSecond")) {
            beanDefinition.getPropertyValues().add("a", getMyBeanSecondAImpl());
        }
    }

    private Object getMyBeanFirstAImpl() {
        return new AImpl();
    }

    private Object getMyBeanSecondAImpl() {
        return new AImpl();
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}