> db.test.count()
  3
> db.test.find({key_strengths:"Hard Working"}).explain()
{
        "cursor" : "BasicCursor",
        "n" : 2,
        "nscannedObjects" : 3,
        "nscannedObjectsAllPlans" : 3,
        ...
}
>