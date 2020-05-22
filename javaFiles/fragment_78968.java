Object o = getClass().getMethod("create_" + type).invoke(null);

static Object1 create_object1() {
     return new Object1(/* with args */);
}

static Object2 create_object2() {
     return new Object2(/* with other args */);
}