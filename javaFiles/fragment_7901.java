Iterator<Foo> aggregate = datastore.createAggregation(Foo.class)
       .project(projection("_id").suppress(),
           projection("field1", "_id"),
           projection("field2"), projection("field3"),
           projection("sales", multiply(projection("value"), projection("amount"))))
      .group("field3", grouping("totalSales", sum("sales")));