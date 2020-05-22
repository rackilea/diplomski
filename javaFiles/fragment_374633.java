BSONObject personBsonObj = BasicDBObjectBuilder.start()
                .add("name","John Doe")
                .add("age",21)
                .add("address",null).get();


 if you are using spring data mongo use

mongoTemplate.insert(personBsonObj,"personCollection");
document in the db:
db.personCollection.findOne().pretty();
{"age":21,"name":"John Doe";"address":null}*