public void searchInfo(String[] keywords){
Connection conn = null;
Statement stmt = null;
try{

  Class.forName("com.mysql.jdbc.Driver");

  conn = DriverManager.getConnection(DB_URL, USER, PASS);

  stmt = conn.createStatement();

  String sql = "SELECT * FROM my_Table ";
  if(keywords[0]!= null || keywords[1]!= null || keywords[2]!= null){
     sql+=" WHERE ";
     if(keywords[0]!= null){
        sql+=" id= ?";
        stmt.setInt(1, Integer.parseInt(keywords[0]));
        if(keywords[1]!= null){
            sql+="AND firstname= ? ";
            stmt.setString(1, keywords[1]);
            if(keywords[2]!= null){
               sql+="AND secondname= ? ";
               stmt.setString(2, keywords[2]); 
            }
        }else if(keywords[2]!= null){
              sql+="AND secondname= ? ";
              stmt.setString(1, keywords[2]); 
        }
     }else if(keywords[1]!= null){
        sql+=" firstname= ? ";
        stmt.setString(1, keywords[1]);
        if(keywords[2]!= null){
           sql+="AND secondname= ? ";
           stmt.setString(2, keywords[2]); 
        }
     }else if(keywords[2]!= null){
              sql+=" secondname= ? ";
              stmt.setString(1, keywords[2]); 
           }
  }
  ResultSet rs = stmt.executeQuery(sql);
  while(rs.next()){
     //Retrieve by column name
     int id  = rs.getInt("id");
     String first = rs.getString("firstname");
     String second = rs.getString("secondname");

     //Display values
     System.out.print("ID: " + id);
     System.out.print(", Firstname: " + first);
     System.out.print(", Secondname: " + second);
  }
  rs.close();
  }catch(SQLException se){
      se.printStackTrace();
  }catch(Exception e){
      e.printStackTrace();
  }finally{
     try{
        if(stmt!=null)
           conn.close();
     }catch(SQLException se){
     }
     try{
        if(conn!=null)
            conn.close();
     }catch(SQLException se){
        se.printStackTrace();
     }
  }//end try
  }