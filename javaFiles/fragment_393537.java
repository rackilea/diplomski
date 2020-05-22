ResultSet res =
            stmt.executeQuery(" SELECT FIRST_NAME FROM  USER vu, USER_PROFILE vup "+
                              " WHERE vup.USER_ID = vu.USER_ID "+
                              "AND vu.USER_ID = ( SELECT USER_ID "+
                             " FROM USER "+ 
                             " WHERE EMAIL_ID = '"+userName+"' "+ 
                             " AND PW_ENCRYPTED = '"+password+"')");