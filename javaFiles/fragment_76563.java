myqueries
 .parallelstream()
 .flatMap( m-> { 
    //queryresult is a stream which return database rows
    return queryresult;
 })
 .collect(Collectors.toMap(
               g-> Arrays.<Object>asList(g.getCountry(), g.getCity()),
               v -> { 
                      MyResultClass item = new MyResultClass();
                      item.setCountry(v.getCountry());
                      item.setCity(v.getCity());
                      return item;
                    },
                (t, u) -> {
                       t.setSumField1(t.getSumField1() + u.getSumField1());
                       t.setSumField2(t.getSumField2() + u.getSumField3());
                       t.setSumField3(t.getSumField3() + u.getSumField3());
                       return t;
                      }
                 )
                .values().forEach(f-> {

                //print the MyResultClass fields
                });