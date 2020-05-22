CommandResult commandResult = db.command(searchCmd);
BasicDBList results = (BasicDBList)commandResult.get("results");
for( Iterator< Object > it = results.iterator(); it.hasNext(); )
{
    BasicDBObject result  = (BasicDBObject) it.next();
    BasicDBObject dbo = (BasicDBObject) result.get("obj");
    System.out.println(dbo.getString("Filename"));
}