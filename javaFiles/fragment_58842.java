// in MyType

static <T> BiConsumer<TypeOfArg,MyType> transfer(
        Function<TypeOfArg,T> from, BiConsumer<MyType,T> to) {
    return (arg,myself) -> {
        T value = from.apply(arg);
        if(value!=null) to.accept(myself, value);
    };
}
static final BiConsumer<TypeOfArg,MyType> TRANSFER_ALL_PROPERTIES =
    transfer(TypeOfArg::getH, MyType::setH).andThen(
    transfer(TypeOfArg::getV, MyType::setV).andThen(
    transfer(TypeOfArg::getS, MyType::setS)));

void mutatorMethod(TypeOfArg arg) {
    TRANSFER_ALL_PROPERTIES.accept(arg, this);
}