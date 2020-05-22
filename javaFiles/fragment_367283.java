<bean id="dataSource"
    class="org.springframework.jdbc.datasource.DriverManagerDataSource">
    <property name="driverClassName" value="${jdbc.driverClassName}" />
    <property name="url" value="${jdbc.url}" />
    <property name="username" value="${jdbc.username}" />
    <property name="password" value="${jdbc.password}" />
</bean>

<bean id="genericDatabaseCaller"
    class="co.com.custom.GenericDatabaseCaller">
    <property name="dataSource" ref="dataSource" />
</bean>