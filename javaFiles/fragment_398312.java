//Add One Point
    Document memberdoc = new Document("Username", event.getAuthor().getName());
    Document found = (Document) collection.find(memberdoc).first();
    if (found == null){
        memberdoc.append("Points", 1);
        memberdoc.append("UserID", event.getAuthor().getId());
        collection.insertOne(memberdoc);
        membersDataHashMap.put(event.getAuthor().getId(), new MembersData(event.getAuthor().getName(), event.getAuthor().getId(), 1));
    }else{
        String  id = found.getString("UserID");
        int points = found.getInteger("Points");
        collection.updateOne(
            eq("UserID", found.getString("UserID")),
            new Document("$inc", new Document("Points", 1))
        );
        membersDataHashMap.put(event.getAuthor().getId(), new MembersData(event.getAuthor().getId(),id,points + 1));
    }
    //End