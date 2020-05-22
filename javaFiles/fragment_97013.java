ArrayList<Foo> list = new ArrayList();
Foo aFoo = new Foo();
aFoo.Bar = 2;
list.Add(aFoo);
aFoo.Bar = 3;
list.Add(aFoo);

foreach(x in list):
    print(x);