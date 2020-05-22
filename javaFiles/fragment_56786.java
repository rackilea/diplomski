public <T extends Root> T gets(int type, Class<T> c) {
    switch (type) {
        case 1:
            return c.cast(new A());
        case 2:
            return c.cast(new B());
        default:
            throw new RuntimeException();
    }
}