db.collection.update(
   { "type": "group" },
   { 
      "$set": { "mygroup": "value" }
      "$setOnInsert" { "mygroup": "value" }
   }
)