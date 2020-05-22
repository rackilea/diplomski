<datasource jndi-name="java:jboss/datasources/MyDS" pool-name="MyDS" enabled="true" use-java-context="true">
  <connection-url>jdbc:mysql://localhost:3306/somedatabase?useUnicode=true&amp;characterEncoding=UTF-8</connection-url>
  <driver>mysql</driver>
  <security>
    <user-name>someuser</user-name>
    <password>somepass</password>
  </security>
</datasource>
<drivers>
  <driver name="mysql" module="com.mysql"/>
</drivers>