public <T> void foo(T[] ... params) {
    Class<?> clazz = params[0].getClass();
    if (clazz.equals(short[].class)) {
        //...
    } else if ( ... ) {
        //...
    } else {
        throw new Exception("expected short[] or int[]");
    }
}