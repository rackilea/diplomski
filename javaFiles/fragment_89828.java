<bean id="daoFactory" class="com.sample.factory.DaoFactoryImpl">
    <property name="dbType" value="${dbName}"/>
    <property name="typeMap">
        <map>
            <entry key="Oracle" value-ref="orgService"/>
            <entry key="DB2" value-ref="productService"/>
        </map>
    <property>
</bean>