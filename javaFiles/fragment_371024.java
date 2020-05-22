<util:map id="jpaPropertyMap" key-type="java.lang.String" value-type="java.lang.Object">
    <entry key="hibernate.hbm2ddl.auto" value="${database.ddl.mode}" />
</util:map>

<bean id="managementEntityManagerFactory"
    class="org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean"
    p:dataSource-ref="dataSource"
    p:jpaPropertyMap-ref="jpaPropertyMap" />