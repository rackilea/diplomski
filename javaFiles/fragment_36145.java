try
        {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            String connString="jdbc:odbc:Driver={Microsoft dBASE Driver (*.dbf)};DefaultDir=E:\\db";//DeafultDir indicates the location of the db
            Connection connection=DriverManager.getConnection(connString);
            String sql="SELECT * FROM table_name where condition";// usual sql query
            Statement stmt=connection.createStatement();
            ResultSet resultSet=stmt.executeQuery(sql);
            while(resultSet.next())
            {
                System.out.println();
            }
            System.out.println();
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }