DataStream<TypeWrapper> stream1 = ...

DataStream<TypeA> streamA = stream1.filter(new FilterFunction<TypeWrapper>() {
    @Override
    public boolean filter(TypeWrapper value) throws Exception {
        return value.firstType != null;
    }
})
.map(new MapFunction<TypeWrapper, TypeA>() {
    @Override
    public TypeA map(TypeWrapper value) throws Exception {
        return value.firstType;
    }
});

DataStream<TypeB> streamB = stream1.filter(new FilterFunction<TypeWrapper>() {
    @Override
    public boolean filter(TypeWrapper value) throws Exception {
        return value.secondType != null;
    }
})
.map(new MapFunction<TypeWrapper, TypeB>() {
    @Override
    public TypeB map(TypeWrapper value) throws Exception {
        return value.secondType;
    }
});