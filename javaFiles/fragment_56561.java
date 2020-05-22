input {
  jdbc {
    jdbc_driver_library => "${JDBC_DRIVER_LIB}"
    jdbc_driver_class => "Java::oracle.jdbc.driver.OracleDriver"
    jdbc_connection_string => "jdbc:oracle:thin:@//localhost:1521/XE"
    jdbc_user => "user"
    jdbc_password => "pwd"
    schedule => "* * * * *"
    statement => "SELECT col1 from table1"
  }
}