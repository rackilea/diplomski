Set<Client> clients = new TreeSet<>(); 
ResultSet rs = ps.executeQuery();

while (rs.next()) {
    int clientNumber = rs.getInt(...);
    String clientName = rs.getString(...);
    clients.add(new Client(clientNumber, clientName))
}