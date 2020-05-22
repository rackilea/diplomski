connection.setAutoCommit(false); // Disable Auto Commit
CallableStatement stmt = connection.prepareCall("{call procedure(param,param,param,param)}");
stmt.execute();

Statement stmt2 = connection.createStatement();
ResultSet rs = stmt2.executeQuery("select * from bla_bla_table"); // Result set for Query

connection.commit();