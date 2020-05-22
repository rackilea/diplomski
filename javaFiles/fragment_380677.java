//Page 1
collection.find().limit(pageSize);
//Get the _id of the last document in this page
last_id = ...

//Page 2
users = collection.find({'_id': {$gt: last_id}}).limit(pageSize);
//Update the last id with the _id of the last document in this page
last_id = ...