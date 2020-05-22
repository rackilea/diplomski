<Context>
        <!-- Specify a JDBC datasource -->
        <Resource name="jdbc/LibraryManagementSystem" auth="Container"
        type="javax.sql.DataSource" username="sa" password="abc732XYZ"
        driverClassName="com.microsoft.sqlserver.jdbc.SQLServerDriver"
        url="jdbc:sqlserver://SAI:1433;DatabaseName=LibraryManagementSystem"
        maxActive="10" maxIdle="4" />
   </Context>