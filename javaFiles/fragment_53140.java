if (doIt) {
            pt = (ParameterizedType)newParameterizedType(ptClazz, targs);
            candidate = TypeToken.of(pt);
        }
    }
    return candidate;
}

public static Type newParameterizedType(Class<?> cls, Type... args) {
    TypeResolver resolver = new TypeResolver();
    TypeVariable<?>[] tvars = cls.getTypeParameters();
    for (int i = 0; i < args.length; i++) {
        resolver = resolver.where(tvars[i], args[i]);
    }
    return resolver.resolveType(dumbToGenericType(cls).getType());
}

@SuppressWarnings("unchecked")
public static <T> TypeToken<? extends T> dumbToGenericType(Class<T> cls) {
    return (TypeToken<T>)TypeToken.of(Object.class).getSubtype(cls);
}