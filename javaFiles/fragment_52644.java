public int foo(IntSupplier get, IntSupplier somethingElse) {
    int ret = 0;
    if (somethingElse != null) {
        ret = somethingElse.getAsInt();
    }
    return ret + get.getAsInt();
}