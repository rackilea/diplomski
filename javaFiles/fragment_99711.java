Foo foo = null;
try {
    foo = getFoo();
} catch (ResourceNotFoundException ex) {
    //TODO: log exception?
    foo = null;
}

if (null == foo) {
    logger.warn("blablabla");
    foo = defaultFoo;
    someOtherComplicatedStuff();
}