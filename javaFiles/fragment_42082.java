<Resource type="javax.sql.DataSource"
          name="jdbc/FOODB"
          factory="org.apache.tomcat.jdbc.pool.DataSourceFactory"
          driverClassName="com.microsoft.sqlserver.jdbc.SQLServerDriver"
          url="jdbc:sqlserver://Foobar\Inventory;databaseName=FooInventory;user=johnDoe;password=astrongpassword;"
          validationQuery="SELECT 1"
          validationQueryTimeout="1000"
          testOnBorrow="true"
/>