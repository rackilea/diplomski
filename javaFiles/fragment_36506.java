CallableStatement cs=null;
        ResultSet rs =null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection("jdbc:sqlserver://<server_ip>;databaseName=<dbName>", "<userName>", "<Password>");
            cs = con.prepareCall("exec exampleProcedure");
            int resultNum = 0;
            while (true)
              {
                  boolean queryResult;
                  int rowsAffected;
                  if (1 == ++resultNum)
                  {
                      try
                      {
                          queryResult = cs.execute();
                          System.out.println("QueryResult:"+queryResult);
                      }
                      catch (SQLException e)
                      {
                          System.out.println("Result " + resultNum + " is an error: " + e.getMessage());
                          continue;
                      }
                  }
                  else
                  {
                      try
                      {
                          queryResult = cs.getMoreResults();
                          System.out.println("QueryResult:"+queryResult);
                      }
                      catch (SQLException e)
                      {                       
                          System.out.println("Result " + resultNum + " is an error: " + e.getMessage());
                          continue;
                      }
                  }
                  if (queryResult)
                  {
                      rs = cs.getResultSet();
                      System.out.println("Result " + resultNum + " is a ResultSet: " + rs);
                      //rs.close();
                  }
                  else
                  {
                      rowsAffected = cs.getUpdateCount();
                      System.out.println("rowsAffected:"+rowsAffected);
                      if (-1 == rowsAffected)
                      {
                          --resultNum;
                          break;
                      }
                      System.out.println("Result " + resultNum + " is an update count: " + rowsAffected);
                  }
              }
        } catch (Exception e) {
            e.printStackTrace();
        }