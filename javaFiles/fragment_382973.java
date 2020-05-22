spring.datasource.url=jdbc:h2:mem:tesdb;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE
    spring.datasource.driverClassName=org.h2.Driver
    spring.datasource.username=sa
    spring.datasource.password=

    spring.datasource.testWhileIdle = true
    spring.datasource.validationQuery = SELECT 1

    spring.jpa.show-sql = true
    spring.h2.console.enabled=true // if you need console