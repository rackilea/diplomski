String mongo_id = "{\"$id\":\"54f76bb7404f9990010041b2\"}"

 String MongoIdToString(String mongo_id){
    return mongo_id.split(":")[1].substring(mongo_id.indexOf("\"")).split("\"")[0];
}

  String mongo_id = MongoIdToString(mongo_id);