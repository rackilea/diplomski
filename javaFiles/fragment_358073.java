db.test.createIndex( { a: "text" } )
db.test.find({ $text: { $search: "boxer cat"}})

{ "_id" : ObjectId("555f18eee7b6d1b7e622de3b"), "a" : "also match on cat" }
{ "_id" : ObjectId("555f18eee7b6d1b7e622de3a"), "a" : "wont match as this it the plural BOXERs" }
{ "_id" : ObjectId("555f18eee7b6d1b7e622de36"), "a" : "Boxer One" }
{ "_id" : ObjectId("555f18eee7b6d1b7e622de37"), "a" : "A boxer dog" }
{ "_id" : ObjectId("555f18eee7b6d1b7e622de39"), "a" : "should match BOXER" }