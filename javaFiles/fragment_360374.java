enum MyType { VAL1, VAL2 };
    Map enumMap = Maps.newHashMap();
    map.put("key1", MyType.class);
    ...
    Class c = map.get("key1");
    assertEquals(MyType.VAL1, Enum.valueOf(c, "VAL1"));