private Stream<ExceptionToErrorCode> implementations() throws Exception {
    return ReflectionUtils.getSubclasses("com.czetsuya.api", ExceptionToErrorCode.class).stream().map(p -> {
        try {
            return ExceptionToErrorCode.class.cast(p.newInstance());
        } catch (InstantiationException | IllegalAccessException e) {
            return null;
        }
    });
}