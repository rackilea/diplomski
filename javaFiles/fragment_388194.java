DBObject sort = new BasicDBObject("$sort",
      new BasicDBObject("TaxiLicence", 1)
          .append("GetOff",1)
  );

  DBObject group = new BasicDBObject("$group",
      new BasicDBObject("_id", "$TaxiLicence"
          .append("GetOff", new BasicDBObject( "$first", "$GetOff" ) )
          .append("GeOffLongitude", new BasicDBObject( "$first", "$GeOffLongitude" ))
  );

  AggregationOutput aggout = taxistationOfCollection.aggregate(sort,group);