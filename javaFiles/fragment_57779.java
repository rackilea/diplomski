public ErrorCode of(Exception exception) throws Exception {
    return implementations() //
        .filter(Objects::nonNull)//
        .filter(impl -> impl.canHandle(exception)) //
        .findFirst() //
        .map(impl -> impl.toErrorCode(exception)) //
        .orElse(ErrorCode.UnknownErrorCode.INSTANCE);
}