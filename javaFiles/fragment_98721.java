List<ClientInfo> clientInfos = new ArrayList<>();

clients.add(new ClientInfo(1L, "client@example.com", "John Smith", 
    Arrays.asList(
        new Account(2L, LocalDateTime.of(2017,5,25,12,59), "JSmith", "zzwvp0d9"))
    )
);

io.displayAllClientsInfo(clients);