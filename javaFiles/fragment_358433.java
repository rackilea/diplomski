RuntimeTypeAdapterFactory<FoobarTypeBase> itemFactory = RuntimeTypeAdapterFactory
            .of(FoobarTypeBase.class, "type") // The field that defines the type
            .registerSubtype(FoobarTypeA.class, "foobar")
            .registerSubtype(FoobarTypeB.class) // if the flag equals the class name, you can skip the second parameter.

Gson gson = new GsonBuilder()
            .registerTypeAdapterFactory(itemFactory)
            .create();