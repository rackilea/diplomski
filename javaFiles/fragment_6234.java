log4j.rootLogger=DEBUG,DB
log4j.appender.DB=org.apache.log4j.jdbc.JDBCAppender
log4j.appender.DB.URL=jdbc:mysql://localhost:3306/test
log4j.appender.DB.user=root
log4j.appender.DB.password=root
log4j.appender.DB.sql=INSERT INTO logs(date, user, message,class) VALUES ('%d{yyyy-MM-dd HH:mm:ss}', '%X{User}','%m','%c')
log4j.appender.DB.layout=org.apache.log4j.PatternLayout
log4j.appender.CA.layout.ConversionPattern=INSERT INTO logs (date, user,message,class) VALUES ('%d{yyyy-MM-dd HH:mm:ss}', '%X{User}','%m','%c')

log4j.category.ke.co=ERROR
log4j.category.ke.co.appender-ref=DB