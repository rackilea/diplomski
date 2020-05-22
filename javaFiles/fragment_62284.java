PreparedStatement ps = connection.prepareStatement(
  "SELECT fr.DepartureLocation, fr.Destination, d.Date, d.Time FROM `FlightRoute` fr,"+
  "`Departure` d WHERE d.FlightRouteId = fr.Id AND d.Date > ? AND d.Date < ? "+
  " AND fr.Destination = ?");

ps.setDate(1, dateFrom);
ps.setDate(2, dateTo);
ps.setString(3, destination); //assuming destination is a String 

ResultSet rs = ps.executeQuery();