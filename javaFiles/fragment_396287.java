public class ObjectToBeUpdated
{
  //data
  //getters and setters
}

public void updateObject(ObjectToBeUpdated object) {
    Connection connection = null;
    try {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        connection = DriverManager.getConnection("jdbc:oracle:thin:@:1521:", "", "");

        String sql = UDPATE_STATEMENT with ? for parameters

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, object.getValue1()); //etc
        //get all values from object passed in and set them in order

        preparedStatement.executeUpdate();
        connection.commit();

        connection.close();
        }

    } catch (Exception ex) {
    }
    finally {
      connection.close();
    }
}