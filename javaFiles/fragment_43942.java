Map<String, Class<? extends Milkshake>> obj2impl =
    new HashMap<String, Class<? extends Milkshake>>();
obj2impl.put("Fruit", FruitMilkshake.class);
obj2impl.put("Banana", BananaMilkshake.class);

...

Milkshake milkshake = obj2impl.get(text).newInstance();