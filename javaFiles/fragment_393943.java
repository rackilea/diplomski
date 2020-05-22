mClient = new MongoClient(connectionString);
db = mClient.getDatabase("Your Database Name");

tableCollection = db.getCollection("Your Table Name");
whereQuery = new Document();

whereQuery.put("Your Attribute", typeCB.getSelectedItem().toString());
iterator=tableCollection.find(whereQuery);
cursor = iterator.iterator();

while (cursor.hasNext()) 
{
      /*put your code here*/
}