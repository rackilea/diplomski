<bean id="dateEditor"
    class="org.springframework.beans.propertyeditors.CustomDateEditor">

    <constructor-arg>
        <bean class="java.text.SimpleDateFormat">
            <constructor-arg value="yyyy-MM-dd-HH:mm:ss;z" />
        </bean>
    </constructor-arg>
    <constructor-arg value="true" />

</bean>