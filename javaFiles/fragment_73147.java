//Create Variables
String endDt = "2018-11-08 01:02:03";
String startDt = "2018-11-01 01:02:03";
String timeZone = "GMT+08:00";

//Query Filter
Bson query = Aggregates.match(Filters.and(
     Filters.lte("_id", getObjectId(endDt,timeZone)),
     Filters.gte("_id", getObjectId(startDt,timeZone ))
));

//Objectid to datetime expression
Document toDate = new Document("$toDate", "$_id");
Bson objectIdToDate = Aggregates.projection(Projections.fields(
     Projections.excludeId(),
     Projections.include("score"),
     Projections.computed("date", toDate)
));

//Date expression with timezone
Document dateExpression = Document.parse(
  "{'$dateFromParts':{
   'year':{'$year':{'date':'$date','timezone:'"+ timeZone +"}},
   'month':{'$month':{'date':'$date','timezone':"+ timeZone +"}},
   'day':{'$dayOfMonth':{'date':'$date','timezone':"+ timeZone +"}}
   }}"
);

//Group by Date
Bson group = Aggregates.group(new Document("$_id", dateExpression), Accumlators.sum("score", "$score"));

//final output
Bson fields = Aggregates.projection(Projections.fields(
     Projections.excludeId(),
     Projections.include("score"),
     Projections.computed("date", "$_id")
));

//Fetch matching records
AggregateIterable<Document> iterable = collection.aggregate(Arrays.asList(query,objectIdToDate,group,fields));

//Format results
for(Document document:iterable) {
    document.put("date", formatDateToMonthDay(date)); 
}