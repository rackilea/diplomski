PreparedStatement stmt = anslutning.prepareStatement("INSERT INTO person (nr, fnamn, snamn, address) VALUES (?, ?, ?, ?)");

stmt.setString(1, p.getNr());
stmt.setString(2, p.getFname());
stmt.setString(3, p.getSname());
stmt.setString(4, p.getAddress());