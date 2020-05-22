<bean id="path" class="java.nio.file.Paths" factory-method="get">
    <constructor-arg index="0">
        <value type="java.lang.String">${limits.path}</value>  
    </constructor-arg>
    <constructor-arg index="1">
        <list></list>
    </constructor-arg>
</bean>