public void createBoat(Boat boat, Member member) {
    try {

        ResultSet rs=connection.createStatement().executeQuery("SELECT ID FROM MEMBER WHERE NAME =" + "'" + member.getName() + "'");
        while(rs.next()){
            int memberId=rs.getInt("ID");
            connection.createStatement().execute("Insert into BOAT (Type, Length,MEMBERID) values (" + boat.toString() ",100,"+memberId+" )");
        }
    } catch (SQLException e) {
        System.out.println(e.getMessage());
    }
}