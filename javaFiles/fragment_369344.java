cursor = db.rawQuery("SELECT chatbot FROM sentence " + 
                     "WHERE LENGTH(user) = ( " +
                     " SELECT MAX(LENGTH(user)) FROM sentence " +
                     "  WHERE ? LIKE '%' || " + USER + " || '%' " +
                     ") AND ? LIKE '%' || " + USER + " || '%' ",
                     new String[] { newMessage, newMessage });