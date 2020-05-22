BasicDBList modArgs = new BasicDBList();
modArgs.add("$total");
modArgs.add("$_id");
coll.aggregate(asList(
    group("$groupValue", sum("total", "$weight")),
    project(fields(computed("groupValue", "$_id"),
        include("total"), excludeId(), 
        computed("remainder", new BasicDBObject("$mod", modArgs))))
));