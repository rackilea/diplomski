Future<JsonObject> futureFoo1 = Future.future();
Future<JsonObject> futureFoo2 = Future.future();
Future<JsonObject> futureFoo3 = Future.future();


foo1(uuid, futureFoo1).compose(resultFoo1 -> foo2(resultFoo1.getString("uuid"), futureFoo2))
                      .compose(resultFoo2 -> foo3(resultFoo2.getString("uuid"), futureFoo3))
                      .compose(resultFoo3 -> doSomething(futureFoo1.result(), //access results from 1st call
                                                         futureFoo2.result(), //access results from 2nd call 
                                                         resultFoo3,
                                                         Future.<JsonObject>future().setHandler(aHandler))); //pass the final result to the original handler