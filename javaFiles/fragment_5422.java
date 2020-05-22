<bean id="configLocation" class="java.lang.String">
    <constructor-arg type="java.lang.String" value="file:#{contextParameters['my-filename']:./default-empty-file.properties}"/>
</bean>
<bean id="placeholderConfig" class="org.springframework.beans.factory.config.PropertyPlaceholderConfigurer">
    <property name="location" ref="configLocation"/>
</bean>