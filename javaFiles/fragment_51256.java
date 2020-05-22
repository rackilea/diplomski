---
micronaut:
    application:
        name: webapp
    server:
        port: 8880

---
datasources.default: {}
---
hibernate:
  hbm2ddl:
    auto: update
  cache:
    queries: false
    use_second_level_cache: true
    use_query_cache: false
    region.factory_class: org.hibernate.cache.ehcache.SingletonEhCacheRegionFactory
dataSource:
  url: jdbc:mysql://localhost:3306/db
  dbCreate: create-update
  pooled: true
  jmxExport: true
  driverClassName: com.mysql.jdbc.Driver
  dialect: org.hibernate.dialect.MySQL5InnoDBDialect
  username:  
  password: