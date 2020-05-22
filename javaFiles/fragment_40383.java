String query = " UPDATE client SET nomcomplet = ?, mail = ?, numerocompte = ?, mdp = ? WHERE idclient = ?";

PreparedStatement ps = con.prepareStatement(query);

ps.setString (1, nomcomplet);
ps.setString (2, mail);
ps.setInt (3, numerocompte);
ps.setString (4, mdp);

ps.setInt(5, idclient);