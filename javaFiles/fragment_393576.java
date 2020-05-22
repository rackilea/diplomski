2019-11-26 10:19:57.947 DEBUG 7321 --- [           main] o.s.data.mongodb.core.MongoTemplate      : find using query: { } fields: Document{{}} for class: class sample.data.mongo.models.Stores in collection: stores
Stores{id='1.0', fruits=[apples, pears, oranges, grapes, bananas], vegetables=[celery, squash]}
Stores{id='2.0', fruits=[plums, kiwis, oranges, bananas, apples], vegetables=[broccoli, zucchini, onions]}

2019-11-26 10:19:57.975 DEBUG 7321 --- [           main] o.s.data.mongodb.core.MongoTemplate      : Calling update using query: { } and update: { "$pull" : { "vegetables" : "squash" } } in collection: stores

2019-11-26 10:19:57.985 DEBUG 7321 --- [           main] o.s.data.mongodb.core.MongoTemplate      : find using query: { } fields: Document{{}} for class: class sample.data.mongo.models.Stores in collection: stores
Stores{id='1.0', fruits=[apples, pears, oranges, grapes, bananas], vegetables=[celery]}
Stores{id='2.0', fruits=[plums, kiwis, oranges, bananas, apples], vegetables=[broccoli, zucchini, onions]}