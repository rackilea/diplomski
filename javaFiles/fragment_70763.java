try {
    myClass.getDeclaredField("a").set(obj, "test");
    myClass.getDeclaredField("b").setInt(obj, 1);
} catch (NoSuchFieldException e) {
    // Whatever needs to be done
}