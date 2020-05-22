...
PreparedStatement statement = con.prepareStatement("SELECT CONCAT(Exits, ' ', Stations) AS exitsandstations FROM `table 3` ORDER BY Exits DESC LIMIT 10");
ResultSet result = statement.executeQuery();


while(result.next()){
    System.out.println(result.getString("exitsandstations"));
}
...