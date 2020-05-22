public class MyClass{
  public static String[] ARGS;
  public static void main(String[] args) {
        ARGS = args;
   }
}


<bean id="jmsConnectionFactory" class="org.apache.activemq.ActiveMQConnectionFactory">
<property name="brokerURL">
<value>#{'vm://localhost:'+argsportnumber}</value>
</property>
</bean>