while (...){
        PreparedStatement p = connection.prepareStatement(...);
        try {
          ResultSet r = p.executeQuery();
          try {
            while (r.next()) {
              ....
            }
          } finally {
            try {
              r.close();
            } catch (SQLException e) {
            // log this or something -- prevent these from masking original exception
            }
          }
        }
        finally {
          try {
            p.close();
          } catch (SQLException e) {
            // log this or something -- prevent these from masking original exception
          }
        }
 }