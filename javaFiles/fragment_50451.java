<!-- LDAP config -->

    <bean id="contextSourceTarget" class="org.springframework.ldap.core.support.LdapContextSource">
        <property name="url" value="${ldap.url}" />
        <property name="base" value="${ldap.base}" />
        <property name="userDn" value="${ldap.userDn}" />
        <property name="password" value="${ldap.password}" />
        <property name="pooled" value="false" />
    </bean>

    <bean id="contextSource"
        class="org.springframework.ldap.pool.factory.PoolingContextSource">
        <property name="contextSource" ref="contextSourceTarget" />
    </bean>

    <bean id="ldapTemplate" class="org.springframework.ldap.core.LdapTemplate">
        <constructor-arg ref="contextSource" />
    </bean>