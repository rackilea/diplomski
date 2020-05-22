while(cursor.hasNext()) {
        DBObject tobj = cursor.next();  
        String tempName = (String)tobj.get("name");
        String tempSession = (String)tobj.get("session");
        String tempStringScore = (String)tobj.get("score");

        int tempScore = Integer.parseInt(tempStringScore);

        Player player = new Player(tempName,tempSession,tempScore);
        savePlayers.add(player);
    }