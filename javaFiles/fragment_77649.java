@Autowired
private MongoTemplate mt;

public String ping()
{
    DBObject ping = new BasicDBObject("ping", "1");
    try {
        CommandResult answer = mt.getDb().command(ping);
        return answer.getErrorMessage();
    } catch (Exception e) {
        return e.getMessage();
    }