<bean id="fromDataSource" class="org.springframework.jdbc.datasource.DriverManagerDataSource">
    <property name="driverClassName" value="${from.jdbc.driverClassName}"/>
    <property name="url" value="${from.jdbc.url}"/>
    <property name="username" value="${from.jdbc.username}"/>
    <property name="password" value="${from.jdbc.password}"/>
</bean>

<context:property-placeholder location="from.jdbc.properties"/>

<bean id="toDataSource" class="org.springframework.jdbc.datasource.DriverManagerDataSource">
    <property name="driverClassName" value="${to.jdbc.driverClassName}"/>
    <property name="url" value="${to.jdbc.url}"/>
    <property name="username" value="${to.jdbc.username}"/>
    <property name="password" value="${to.jdbc.password}"/>
</bean>

<context:property-placeholder location="to.jdbc.properties"/>