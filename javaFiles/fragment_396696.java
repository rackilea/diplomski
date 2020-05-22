public String getCurrentSeason(String leagueName)
{
    String qry = "Select * from KHAN.LeagueSeason where league_name = '"+leagueName+"'       AND end_Date IS NULL";
    try{
        ResultSet rs = stmt.executeQuery(qry);

        if(rs.next()) // note: no semicolon here
        {
            String s = rs.getString(1);
            return s;
        }
    }
    catch(SQLException err)
    {
        System.out.println(err.getMessage());
        System.exit(0);
    }
    return "";
}