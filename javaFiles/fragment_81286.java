security:
  basic:
    enabled: ${env.security.basic.enabled:false}
management:
  security:
    enabled: ${env.management.security.enabled:false}


apiUsername: apiUser
apiPassword: apiPassword
apiUrl: http://external-rest-api/RESTAdapter
dbUsername: dbUsername
dbPassword: dbPassword
dbServerUrl: jdbc:jtds:sqlserver://localhost:1433;
dbDriverClass: net.sourceforge.jtds.jdbc.Driver
dbServerDialect: org.hibernate.dialect.SQLServerDialect
dbName: databaseName=dbName;

---
spring:
  profiles: Prod
dbDriverClass: net.sourceforge.jtds.jdbc.Driver
dbServerDialect: org.hibernate.dialect.SQLServerDialect
dbName: databaseName=prodDBName;