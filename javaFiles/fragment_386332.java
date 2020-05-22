for(int i=0; i<unumber; i++) {
        String username = "someuser";
        String column = "column" + Integer.toString(i);;
        PreparedStatement pr = null;
        String query1 = "update table1 set " + column + " = (?) where username = (?)";
        pr = con.prepareStatement(query1);
        pr.setString(1, column);
        pr.setString(2, someuser);
        int s = pr.executeUpdate();
}