public interface BaseServiceLocator {

   BaseService lookup(String qualifier); //use whatever qualifier type makes sense here
}

<bean id="serviceLocatorFactoryBean"
    class="org.springframework.beans.factory.config.ServiceLocatorFactoryBean">
    <property name="serviceLocatorInterface"
              value="your.package.BaseServiceLocator" />
</bean>