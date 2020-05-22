public int create( final Vehicule obj )
{
  try ( final PreparedStatement ps = connect.prepareStatement(
        "INSERT INTO VEHICULE ( MARQUE, MOTEUR, PRIX, NOM, ID ) VALUES ( ?,?,?,?,? )" ) )
  {
    ps.setInt(1, obj.getMarque().getId() );
    ps.setInt(2, obj.getMoteur().getId() );
    ps.setDouble(3, obj.getPrix() );
    ps.setString(4, obj.getNom() );
    ps.setInt(5, obj.getId() );
    System.out.println("VehiculeDAO 85 : vehicule query : \n" + ps);
    return ps.executeUpdate();
  }
  catch (SQLException e)
  {
    e.printStackTrace();
    return 0;
  }
}