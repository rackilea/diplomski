package crash.commands;

import org.crsh.command.BaseCommand;
import org.springframework.beans.factory.BeanFactory;

public abstract class SpringAwareCommand extends BaseCommand {

    private static final String SPRING_BEAN_FACTORY = "spring.beanfactory";

    protected <T> T getBean(Class<T> beanClass) {
        return ((BeanFactory) this.context.getAttributes().get(SPRING_BEAN_FACTORY)).getBean(beanClass);
    }

}