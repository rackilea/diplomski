String newName = "Test";
            int score = 12345;
            int newScore = 54321;
            ResultSet result;
            Statement stat = conn.createStatement();
            result = stat.executeQuery("SELECT * FROM Highscore ORDER BY Score ASC");// use DESC if u want to replace the highest value
            result.next(); 
            if(result.getInt(2) <= score)
            {
               PreparedStatement preparedStatement = conn.prepareStatement("UPDATE  Highscore  SET Name =? Score = ? WHERE Score = ?");
               preparedStatement.setString(1, newName);
               preparedStatement.setString(2, newScore);
               preparedStatement.setString(3, result.getInt(2));
               int updateCount = preparedStatement.executeUpdate();
            }