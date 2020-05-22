<context>
<Realm className="org.apache.catalina.realm.JDBCRealm" debug="99"
      driverName="com.mysql.Driver"
   connectionURL="jdbc:mysql://localhost/mydb?user=dbuser&amp;password=dbpass"
       userTable="users" userNameCol="user_name" userCredCol="user_pass"
   userRoleTable="user_roles" roleNameCol="role_name"/>
</context>