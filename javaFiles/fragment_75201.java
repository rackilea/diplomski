Type type = TypeLiteral.get(Item.class).getType();
Type setType = Types.setOf(type);

PrivateBinder privateBinderOne = binder.newPrivateBinder();
privateBinderOne.bind(MyEnum.class).toInstance(MyEnum.FIRST);
Multibinder<Item> toolsSectionOne = Multibinder.newSetBinder(privateBinderOne , Item.class, FirstSubItems.class);
toolsSectionOne.addBinding().to(Item1.class);
toolsSectionOne.addBinding().to(Item2.class);
privateBinderOne.expose(Key.get(setType, FirstSubItems.class));

PrivateBinder privateBinderTwo = binder.newPrivateBinder();
privateBinderTwo.bind(MyEnum.class).toInstance(MyEnum.SECOND);
Multibinder<Item> toolsSectionTwo = Multibinder.newSetBinder(privateBinderTwo , Item.class, SecondSubItems.class);
toolsSectionTwo.addBinding().to(Item1.class);
toolsSectionTwo.addBinding().to(Item2.class);
privateBinderTwo.expose(Key.get(setType, SecondSubItems.class));