Datastore ds = ...
Query<Record> q = ds.createQuery(Record.class);
q.or(
    q.criteria("authorId").equal(searchId),
    q.criteria("comments.userId").equal(searchId)
);

//list
List<Record> entities = q.asList();