String sql = "CREATE TABLE IF NOT EXISTS " + Userinput.getTableName2() +
" (participant INT(255), " +
" `0` INT(255),"+                     // using backticks
" name INT(3), " + 
" occurances INT(255))";
stmt.executeUpdate(sql);