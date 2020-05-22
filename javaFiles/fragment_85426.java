class CustomModule extends AbstractModule {

static class Holder<T> {
    Class<T> param;
    Class<IAction<T>> klass;

    Holder(Class<?> p, Class<IAction<T>> k) {
        param = (Class<T>) p;
        klass = k;
    }
}

// this would be similar to the result of classpath scanning
List<IAction<?>> stuff;

public <T> void bindSome(Class<T> typeParameter, Class<IAction<T>> implementation) {
    Type parameterizedType = Types.newParameterizedType(IAction.class, typeParameter);
    bind((TypeLiteral<IAction<T>>) TypeLiteral.get(parameterizedType)).to(implementation);
}

public CustomModule() {
    stuff = new ArrayList<>();
    stuff.add(new StringAction());
    stuff.add(new LongAction());
}

@Override
protected void configure() {
    for (IAction<?> act : stuff) {
        System.out.printf("Configuring %s for %s\n", act.getTypeArguments(), act.getClass());
        //the following doesn't work because the compiler cannot understand that 
        //the 1st argument T is the same T in 2nd argument Class<T>
        //bindSome(act.getTypeArguments(), act.getClass());

        //w00t? compiler is tricked?? <String> is erased, but the holder preserves proper class?
        Holder<String> holder = new Holder(act.getTypeArguments(), (Class<IAction<String>>) act.getClass());
        bindSome(holder.param, holder.klass);

        //this is what I want to avoid doing manually
        //bind(new TypeLiteral<IAction<String>>() {}).to(StringAction.class);
    }
}
}