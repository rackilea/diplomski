<!-- first data source -->
<bean id="majorDataSource" class="org.postgresql.ds.PGSimpleDataSource">
    <property name="serverName" value="${jdbc.major.serverName}" />
    <property name="portNumber" value="${jdbc.major.portNumber}" />
    <property name="user" value="${jdbc.major.username}" />
    <property name="password" value="${jdbc.major.password}" />
    <property name="databaseName" value="${jdbc.major.databaseName}" />
</bean>
<!-- second data source -->
<bean id="minorDataSource" class="org.postgresql.ds.PGSimpleDataSource">
    <property name="serverName" value="${jdbc.minor.serverName}" />
    <property name="portNumber" value="${jdbc.minor.portNumber}" />
    <property name="user" value="${jdbc.minor.username}" />
    <property name="password" value="${jdbc.minor.password}" />
    <property name="databaseName" value="${jdbc.minor.databaseName}" />
</bean>
<!-- facade data source -->
<bean id="dataSource" class="blog.datasource.CustomerRoutingDataSource">
   <property name="targetDataSources">
      <map>
         <entry key="MINOR" value-ref="minorDataSource"/>
         <entry key="MAJOR" value-ref="majorDataSource"/>
      </map>
   </property>
   <property name="defaultTargetDataSource" ref="majorDataSource"/>
</bean>
<!-- wiring up -->
<bean id="transactionManager" class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
    <property name="dataSource" ref="dataSource"/>
</bean>
<tx:annotation-driven transaction-manager="transactionManager"/>
<bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
    <property name="dataSource" ref="dataSource"/>
    <property name="configLocation" value="classpath:sqlmap-config.xml"/>
</bean>