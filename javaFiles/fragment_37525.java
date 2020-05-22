<domain log-root="${com.sun.aas.instanceRoot}/logs" application-root="${com.sun.aas.instanceRoot}/applications" version="10.0">
  <system-applications/>
  <applications/>
  <resources>
    <jdbc-resource pool-name="MyPool" jndi-name="jdbc/mylog"/>
    ...
    <jdbc-connection-pool driver-classname="" datasource-classname="org.apache.derby.jdbc.ClientDataSource" res-type="javax.sql.DataSource" description="" name="MyPool" ping="true">
      <property name="User" value="APP"></property>
      <property name="RetrieveMessageText" value="true"></property>
      <property name="CreateDatabase" value="true"></property>
      <property name="ServerName" value="localhost"></property>
      <property name="Ssl" value="off"></property>
      <property name="SecurityMechanism" value="4"></property>
      <property name="TraceFileAppend" value="false"></property>
      <property name="TraceLevel" value="-1"></property>
      <property name="PortNumber" value="1527"></property>
      <property name="LoginTimeout" value="0"></property>
      <property name="Password" value="APP"></property>
      <property name="databaseName" value="MYDB"></property>
    </jdbc-connection-pool>
    ...
  </resources>
  <servers>
    <server name="server" config-ref="server-config"> 
      <resource-ref ref="jdbc/__TimerPool"/>
      <resource-ref ref="jdbc/__default"/>
      <resource-ref ref="jdbc/mylog"/>
    </server>
  </servers>
  ...
...