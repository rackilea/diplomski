JavaRDD<Integer> queryKeys = ...;
JavaRDD<BasicDBObject> queries = queryKeys.map(value -> new BasicDBObject("keyName", value));
BasicDBObject orQuery = SomeHelperClass.buildOrQuery(queries.collect());
List<Document> queryResults = db.getCollection("docs").find(orQuery).into(new ArrayList<>());

JavaRDD<Document> parallelResults = sparkContext.parallelize(queryResults);
JavaRDD<ObjectContainingKey> results = parallelResults.map(doc -> SomeHelperClass.fromJSONtoObj(doc));
JavaPairRDD<Integer, Iterable<ObjectContainingKey>> keyResults = results.groupBy(obj -> obj.getKey());