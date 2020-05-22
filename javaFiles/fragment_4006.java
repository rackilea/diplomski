public class BezoekerModel { 
public Gebruiker getGebruiker(String username, String password) { 
Gebruiker user = null;
ResultSet result = processQuery("SELECT * FROM gebruiker WHERE gebruikersnaam = ? AND wachtwoord = ?;",username,password);
    while (result.next()) { 
    String gebruikerstype = result.getString("gebruikerstype");
    String voornaam = result.getString("voornaam");
    String tussenvoegsel = result.getString("tussenvoegsel");
    String achternaam = result.getString("achternaam"); 
    int schoolcode = result.getInt("schoolcode"); 
    user = new Gebruiker(voornaam, tussenvoegsel, achternaam, gebruikerstype, schoolcode); 
    } 
} catch (SQLException ex) { 
     ex.printStackTrace(); 
} finally { 
     if (result != null || stat != null || conn != null) {
           try {
           result.close(); 
           stat.close(); 
           conn.close();
           }
} catch (SQLException ex) { 
      System.out.println("Error: " + ex.toString());
 }
      } //end of if
 } return user; } }