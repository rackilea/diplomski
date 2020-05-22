static CommonNumber someCommonNumberProcessor(CommonNumber cn) {
    return cn;
}

public CommonNumber apply(CommonNumber t) {
    return Optional.of(t).filter(NumberValidation.isExisting(Test2::someCommonNumberProcessor)).get();
}