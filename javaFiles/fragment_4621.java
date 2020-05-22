public <T extends Model> HasOne<T> aMethod(Class<T> clazz){

    HasOne<T> hasOne = injector.getInstance(Key.get(new TypeLiteral<HasOne<T>>() {
    }));

    return hasOne;
}