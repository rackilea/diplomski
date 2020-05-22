Statement stmt = conn.createStatement();
sql = "INSERT INTO nameBook(name3, name2, name1) " +
      "VALUES( ";
for(String name : nameSet){
    sql = sql.concat(" '" + name + "' , ");
}

sql = sql.concat(")");
stmt.executeUpdate(sql);