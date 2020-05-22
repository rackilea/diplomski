class Utility{
    static String username;
    static String password;
    public static setUserNameAndPassword(String username, String password){
        Utility.username = username;
        Utility.password = password;
    }
    //other stuff
}

<bean
    class="org.springframework.beans.factory.config.PropertyPlaceholderConfigurer">
    <property name="locations">
        <list>
            <value>classpath*:/myservice_detaults.properties</value>
            <value>classpath*:/log4j.properties</value>
        </list>
    </property>
</bean>

<bean class="org.springframework.beans.factory.config.MethodInvokingFactoryBean">
    <property name="staticMethod" value="foo.bar.Utility.setUserNameAndPassword"/>
    <property name="arguments">
        <list>
            <value>${username}</value>
            <value>${password}</value>
        </list>
   </property>
</bean>