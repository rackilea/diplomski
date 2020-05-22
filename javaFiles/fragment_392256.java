create index on :User(id);

USING PERIODIC COMMIT 1000
LOAD CSV FROM "file:///home/michael/import/friendster/friends-000______.txt" as line FIELDTERMINATOR ":"
MERGE (u1:User {id:line[0]})
;

USING PERIODIC COMMIT 1000
LOAD CSV FROM "file:///home/michael/import/friendster/friends-000______.txt" as line FIELDTERMINATOR ":"
WITH line[1] as id2
WHERE id2 <> '' AND id2 <> 'private' AND id2 <> 'notfound'
UNWIND split(id2,",") as id
WITH distinct id
MERGE (:User {id:id})
;

USING PERIODIC COMMIT 1000
LOAD CSV FROM "file:///home/michael/import/friendster/friends-000______.txt" as line FIELDTERMINATOR ":"
WITH line[0] as id1, line[1] as id2
WHERE id2 <> '' AND id2 <> 'private' AND id2 <> 'notfound'
MATCH (u1:User {id:id1})
UNWIND split(id2,",") as id 
MATCH (u2:User {id:id})
CREATE (u1)-[:FRIEND_OF]->(u2)
;