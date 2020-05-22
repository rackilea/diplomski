connection.setAutoCommit(false);
ps = DBConnection.prepareStatement(sql);
ps.setString(1, imageID);

ps2 = DBConnection.prepareStatement(sql);
ps2.setString(1, imageID);

int count = ps.executeUpdate();
count += ps2.executeUpdate();

connection.commit();