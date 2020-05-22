Example<Foo> fooExample = new Example<Foo>();
Foo foo = fooExample.getFooField();
System.out.println(foo.getId());
System.out.println(foo.getType());

Example<FooBar> fooBarExample = new Example<FooBar>();
FooBar fooBar = fooBarExample.getFooField();
System.out.println(fooBar.getId());
System.out.println(fooBar.getType());
System.out.println(fooBar.getExtraField());