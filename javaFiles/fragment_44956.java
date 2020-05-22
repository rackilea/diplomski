public void someMethod(Foo foo) {
    Bar bar = foo.getBar();
    logger.info(bar.getFirstName());
    logger.info(bar.getLastName());
    logger.info(bar.getBirthday());
    Baz baz = bar.getBaz();
    logger.info(baz.getSomefield());
    //and on...
}