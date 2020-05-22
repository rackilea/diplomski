PreparedStatement p = c.prepare("INSERT INTO WORDS (ID,CAT,WORD) VALUES(?, ?, ?)");
p.setInt(1, i);
p.setString(2, wordcat);
p.setString(3, word);
p.execute();
//commit results if using InnoDB, etc