<bean id="a" class="com.foo.bar.ClassA">
        <property name="prop1" value="#{args[0]}" />
    </bean>

    <bean id="b" class="com.foo.bar.ClassB">
        <property name="prop2" ref="a" />
    </bean>