BooleanBuilder builder = new BooleanBuilder();

if(someName != null){
    builder.and(QMyClass.name.eq(someName));
}
if(someTime != null){
    builder.and(QMyClass.time.eq(someTime));
}

repository.findAll(builder.getValue())