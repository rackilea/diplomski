String sql = 
 "select id, name from user where email=" + email + " and password = " + password;

RawSql rawSql =   
 RawSqlBuilder  
    .parse(sql)
    .columnMapping("id",  "user.id")  
    .columnMapping("name",  "user.name")
    .create();  

Query<User> query = Ebean.find(User.class);  
query.setRawSql(rawSql);  

List<User> list = query.findList();