while (true) {
    for(Player p : playerList) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(p.getSocket().getInputStream()));
        String data;
        while ((data = reader.readLine() != null) {
            p.packetRecieved(data);
        }
    }
}