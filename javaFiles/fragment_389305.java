public List<MyModel> findByFilter(FilterObject filterObject) {
    BooleanBuilder builder = new BooleanBuilder();

    QMyModel mymodel = QMyModel.myModel;

    add(builder, filterObject.getName(), mymodel.name::contains);
    add(builder, filterObject.getStatus(), mymodel.status::in);

    ...
}

private <T> void add(BooleanBuilder builder, T filterElement, Function<T, BooleanExpression> booleanExpressionFunction) {
    if (valid(filterElement)) {
        builder.and(booleanExpressionFunction.apply(filterElement));
    }
}

private boolean valid(Object filterElement) {
    if (filterElement == null) {
        return false;
    }
    if (filterElement instanceof Collection) {
        return !((Collection) filterElement).isEmpty();
    }
    return true;
}