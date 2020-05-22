ResultSet rs=smt.executeQuery("select * from posttopic where name='"+logn+"'");
// Create a date formatter with pattern as required: year-month-day hour:minute:second
java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
while(rs.next())
{
    name=rs.getString(1);
    title=rs.getString(2);
    subject=rs.getString(3);
    message=rs.getString(4);
    date=rs.getTimestamp(5);
    System.out.print(sdf.format(date)); // Format the date using the specified pattern.
}