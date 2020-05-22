Bson queryFilter = eq( "_id", "FlightLegPaxRecord::UA::141::2019-09-07::ORD::DEN" );

List<Bson> arrayFilters = new ArrayList<>();
arrayFilters.add(new Document( "tc.travelCountType", "ActionStatus" )); // "tc" for "travelerCounts"
arrayFilters.add(new Document( "ct.key", "J" )); // "ct" for "travelerCounts.counts"
UpdateOptions​ updateOptions = new UpdateOptions​().arrayFilters(arrayFilters);

Bson update = set( "travelerCounts.$[tc].counts.$[ct].value", "99" );

UpdateResult result = collection.updateOne(queryFilter, update, updateOptions);