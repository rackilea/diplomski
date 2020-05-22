<bean id="machineName" class="java.lang.String">
   <constructor-arg value="#{T(java.net.InetAddress).localHost.hostName}"/>
</bean>

<rabbit:queue id="fooQueue"
              name="fooQueue.#{ machineName }"
              durable="false"
              auto-delete="false"
              exclusive="false" />