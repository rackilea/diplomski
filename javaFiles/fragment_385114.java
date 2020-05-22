<bean id="sslContext" class="com.liquidtelecoms.tillintegration.FileTcpSSLContextSupport">
    <constructor-arg value="${java.home}/lib/security/cacerts" />
    <constructor-arg value="${java.home}/lib/security/cacerts" />
    <constructor-arg value="changeit" />
    <constructor-arg value="changeit" />
</bean>