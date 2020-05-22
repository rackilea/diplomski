String sql = "update  Customer set FirstName= AES_ENCRYPT(?,'uk112'),MiddleName= AES_ENCRYPT(?,'uk112'),LastName= AES_ENCRYPT(?,'uk112'),DOB=?,Gander= AES_ENCRYPT(?,'uk112'),Address= AES_ENCRYPT(?,'uk112'),City= AES_ENCRYPT(?,'uk112'),PostCode= AES_ENCRYPT(?,'uk112') where ID=?";

    pst = conn.prepareStatement(sql);
    pst.setString(1, value2);
    pst.setString(2, value3);
    pst.setString(3, value4);
    pst.setString(4, value5);
    pst.setString(5, value6);
    pst.setString(6, value7);
    pst.setString(7, value8);
    pst.setString(8, value9);
    pst.setString(9, value1);
    pst.execute();