public boolean isLogin(String type, String user, String pass) throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String query = "select * from users where type = ? 
            and username = ? and password = ?";
        try {
           //other code

            //if returns result from db
            if(resultSet.next()) {
                return true;
            }
            else {
                //String typeQuery = "select * from users where type = ?";
                //Execute the typeQuery and throw TypeNotFoundException

                //String userNameQuery = "select * from users where username = ?";
                //Execute the userNameQuery and throw UserNameNotFoundException

                return false;
            }
        } //other code as is
    }