String UserID = obj.get("UserID").toString();
cursor = users.find(whereQuery);
if(cursor.hasNext()) {
    // the object will be your object, its basically a json document
    BasicDBObject obj = cursor.next(); 

    // print obj to console as json file
    System.out.println(obj);

    // you can get any property with obj.get...(); method such as .getString()
    // The below code will extract the User_ID from the object you received via find query 
    string id = obj.getString("User_ID");
}