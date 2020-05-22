Foo myFoo = service.getFoo();
doFooThings(myFoo);

Bar myBar = myFoo.getBar();
doBarThings(myBar);

Baz myBaz = myBar.getBaz();
doBazThings(myBaz);
doMoreBazThings(myBaz);
doOneLastAmazingBazThing(myBaz);