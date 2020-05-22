db.ct_work.find(
{ $or:[{"field1":{$lt:0}},
    {"$where":"this.field2 >= this.field3"}]}) 

## in java  you  do with  Filters.where  or  create  a  DBObject

Filters.where("this.a > this.b") 

DBObject obj = new BasicDBObject();
obj.put("$where", "this.subNum >= this.stuNum");