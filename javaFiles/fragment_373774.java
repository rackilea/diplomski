try {
    throw new Exception(
        new Exception(
            new Exception(
                new RuntimeException("This is the one I am interested in", new RuntimeException()))));

} catch (Exception e) {
    dig(e);
}

private void dig(Throwable e) {
    if (e instanceof RuntimeException) {
        log.info("Some message " + e);

    } else if (e != null) {
        dig(e.getCause());
    }
}