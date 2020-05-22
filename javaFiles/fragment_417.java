#For Public Website
spring.datasource.web.driver = com.microsoft.sqlserver.jdbc.SQLServerDriver
spring.datasource.web.url = jdbc:sqlserver://127.0.0.01\\dbo:1433;databaseName= PROD_WEB;
# Username and password
spring.datasource.web.username = web
spring.datasource.web.password = ED5FLW64ZU976Q36

#For Rest API
spring.datasource.rest.driver = com.microsoft.sqlserver.jdbc.SQLServerDriver
spring.datasource.rest.url = jdbc:mysql://localhost:3306/PROD_REST;
# Username and password
spring.datasource.rest.username = rest
spring.datasource.rest.password = Firewall77#