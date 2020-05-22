public void callDatabase(String date1, String date2){   
    PreparedStatement stmt=con.prepareStatement("select absentdt, period from stu_attendancemaster where classid=70 AND absentdt BETWEEN '"+date1+"' AND '"+date2+"' ");
    ResultSet rs=stmt.executeQuery();   
    while(rs.next())
    {
        //get data here
    }
}