•   <dataConfig>
•   <dataSource type="JdbcDataSource" driver="com.microsoft.sqlserver.jdbc.SQLServerDriver" url="jdbc:sqlserver://X.Y.Z.U:1433;databaseName=myDB" user="test" password="tester" /> 
•   <document>
•   <entity name="Text" query="select DocumentId, Data from Text">
•   <field column="DocumentId" name="DocumentId" /> 
•   <field column="Data" name="Data" /> 
•   </entity>
•   </document>
•   </dataConfig>