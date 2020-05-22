final BasicDBObject dbObj = null;
if (dbObj.get("computers") != null){
    computerList =  (BasicDBList) dbObj.get("computers");
}
for ( obj : computerList) {
    final BasicDBObject computerAsDBObject = (BasicDBObject) obj;
    final Computer computer = new Computer(computerAsDBObject.getString("name"), 
                                           computerAsDBObject.getInt("ipAddress"));
    System.getComputers().add(computer);
}