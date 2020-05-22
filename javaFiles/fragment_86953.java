public void update(User user)
{
    try
    {
    PreparedStatement pr=connection.prepareStatement("UPDATE tablename SET firstname=?, middlename=?, lastname=? where acid=?");

          pr.setString(1, user.getFirstName());
          pr.setString(2, user.getMiddleName());
          pr.setString(3, user.getLastName());
          pr.setInt(4, user.getA.CNO());
          ps.executeUpdate();
     }
     catch(Exception e)
     {
          System.out.println(e);
     }
}