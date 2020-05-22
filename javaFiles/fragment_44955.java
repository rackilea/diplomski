public void someMethod(Foo foo) {
    logger.info(foo.getBar().getFirstName());
    logger.info(foo.getBar().getLastName());
    logger.info(foo.getBar().getBirthday());
    logger.info(foo.getBar().getBaz().getSomefield());
    //and probably more other operations not directly involved with logger.info...
}