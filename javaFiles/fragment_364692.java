<bean id="dataSource" class="org.springframework.jdbc.datasource.DriverManagerDataSource">
    <property name="url" value="${db.url}" />
    <property name="username" value="${db.user}" />
    <property name="password" value="${db.password}" />
    <!-- drivers and other stuff -->
</bean>