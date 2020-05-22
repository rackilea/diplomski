public List<MyClass> getStudentList(String studentName){
    studentName = ".*" + studentName + ".*";

/*  BasicDBObject field = new BasicDBObject();
    field.put("regNo", 1);
    field.put("name", 1);
    field.put("collName", 1);
    field.put("deptName", 1);  */

    Query query = new Query(Criteria.where("name").regex(studentName, "i"));

    query.fields().include("regNo").include("name").include("collName").include("deptName").exclude("_id");

    return mongoTemplate.find(query,MyClass.class, COLLECTION_NAME);
}