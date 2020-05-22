private static class Field<T> {
    final Function<User, T> getter;
    final BiConsumer<User, T> setter;

    Field(Function<User, T> getter, BiConsumer<User, T> setter) {
        this.getter = getter;
        this.setter = setter;
    }

    boolean sync(User src, User dst) {
        T srcField = getter.apply(src);
        if (!Objects.equal(srcField, getter.apply(dst))) {
            setter.accept(dst, srcField);
            return true;
        }
        return false;
    }
}

private static final List<Field<?>> FIELDS = Arrays.asList(
        new Field<>(User::getEmail, User::setEmail),
        new Field<>(User::getFirstName, User::setFirstName),
        new Field<>(User::getLastName, User::setLastName),
        new Field<>(User::getFullName, User::setFullName));

public boolean syncWithFieldsFrom(User currentUser) {
    boolean updated = false;
    for (Field<?> f : FIELDS) {
        updated |= f.sync(currentUser, this);
    }
    return updated;
}