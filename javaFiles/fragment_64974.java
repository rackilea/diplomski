Foo fooInstance1 = new Foo();
Foo fooInstance2 = new Foo();
IComposite<Foo> myComposite = new Composite<Foo>(Foo.class);
myComposite.add(fooInstance1);    
myComposite.add(fooInstance2);    
// invokes Method1 on instance1 and instance2 transparently
myComposite.getComponent().Method1();

// alternatively do
Foo myCompositeFoo = myComposite.getComponent();
// pass this myCompositeFoo around and do
myCompositeFoo.Method1();