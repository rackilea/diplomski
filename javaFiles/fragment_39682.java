<!-- DataSource configuration for Apache Commons DBCP. -->
    <bean id="dataSource" class="org.apache.commons.dbcp.BasicDataSource" destroy-method="close"
          p:driverClassName="${jdbc.driver}" p:url="${jdbc.url}"
          p:username="${jdbc.username}" p:password="${jdbc.password}"/>

 <!--jdcb template for DB tests-->
    <bean id="jdbcTemplate" class="org.springframework.jdbc.core.simple.SimpleJdbcTemplate">
        <constructor-arg type="javax.sql.DataSource" ref="dataSource"/>
    </bean>