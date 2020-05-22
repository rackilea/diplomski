class Substitution extends HashMap<String, TypeExpr> {
    Substitution(TypeVariable[] formals, TypeExpr[] actuals) {
        for (int i = 0; i < actuals.length; i++) {
            put(formals[i].getName(),actuals[i]);
        }
    }

}

abstract class TypeExpr {
    abstract TypeExpr apply(Substitution s);

    public abstract String toString(); 

    static TypeExpr from(Type type) {
        if (type instanceof TypeVariable) {
            return new TypeVar((TypeVariable) type);
        } else if (type instanceof Class) {
            return new ClassType((Class) type);
        } else if (type instanceof ParameterizedType) {
            return new ClassType((ParameterizedType) type);
        } else if (type instanceof GenericArrayType) {
            return new ArrayType((GenericArrayType) type);
        } else if (type instanceof WildcardType) {
            return new WildcardTypeExpr((WildcardType) type);
        }
        throw new IllegalArgumentException(type.toString());
    }

    static TypeExpr[] from(Type[] types) {
        TypeExpr[] t = new TypeExpr[types.length];
        for (int i = 0; i < types.length; i++) {
            t[i] = from(types[i]);
        }
        return t;
    }

    static TypeExpr[] apply(TypeExpr[] types, Substitution s) {
        TypeExpr[] t = new TypeExpr[types.length];
        for (int i = 0; i < types.length; i++) {
            t[i] = types[i].apply(s);
        }
        return t;
    }

    static void append(StringBuilder sb, String sep, Object[] os) {
        String s = "";
        for (Object o : os) {
            sb.append(s);
            s = sep;
            sb.append(o);
        }
    }
}

class TypeVar extends TypeExpr {
    final String name;

    public TypeVar(String name) {
        this.name = name;
    }

    public TypeVar(TypeVariable var) {
        name = var.getName();
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    TypeExpr apply(Substitution s) {
        TypeExpr e = s.get(name);
        return e == null ? this : e;
    }
}

class ClassType extends TypeExpr {
    final Class clazz;
    final TypeExpr[] arguments; // empty if the class is not generic

    public ClassType(Class clazz, TypeExpr[] arguments) {
        this.clazz = clazz;
        this.arguments = arguments;
    }

    public ClassType(Class clazz) {
        this.clazz = clazz;
        arguments = from(clazz.getTypeParameters());
    }

    @Override
    public String toString() {
        String name = clazz.getSimpleName();
        if (arguments.length == 0) {
            return name;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(name);
        sb.append("<");
        append(sb, ", ", arguments);
        sb.append(">");
        return sb.toString();
    }

    public ClassType(ParameterizedType pt) {
        clazz = (Class) pt.getRawType();
        Type[] args = pt.getActualTypeArguments();
        arguments = TypeExpr.from(args);
    }

    @Override
    ClassType apply(Substitution s) {
        return new ClassType(clazz, apply(arguments, s));
    }
}

class ArrayType extends TypeExpr {
    final TypeExpr componentType;

    public ArrayType(TypeExpr componentType) {
        this.componentType = componentType;
    }

    public ArrayType(GenericArrayType gat) {
        this.componentType = TypeExpr.from(gat.getGenericComponentType());
    }

    @Override
    public String toString() {
        return componentType + "[]";
    }

    @Override
    TypeExpr apply(Substitution s) {
        return new ArrayType(componentType.apply(s));
    }
}

class WildcardTypeExpr extends TypeExpr {
    final TypeExpr[] lowerBounds;
    final TypeExpr[] upperBounds;

    public WildcardTypeExpr(TypeExpr[] lowerBounds, TypeExpr[] upperBounds) {
        this.lowerBounds = lowerBounds;
        this.upperBounds = upperBounds;
    }

    WildcardTypeExpr(WildcardType wct) {
        lowerBounds = from(wct.getLowerBounds());
        upperBounds = from(wct.getUpperBounds());
    }

    @Override
    TypeExpr apply(Substitution s) {
        return new WildcardTypeExpr(
            apply(lowerBounds, s), 
            apply(upperBounds, s)
        );
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("?");
        if (lowerBounds.length > 0) {
            sb.append(" super ");
            append(sb, " & ", lowerBounds);
        }
        if (upperBounds.length > 0) {
            sb.append(" extends ");
            append(sb, " & ", upperBounds);
        }
        return sb.toString();
    }
}

public class Test {

    /**
     * @return {@code superClazz}, with the replaced type parameters it has for
     *         instances of {@code ct}, or {@code null}, if {@code superClazz}
     *         is not a super class or interface of {@code ct}
     */
    static ClassType getSuperClassType(ClassType ct, Class superClazz) {
        if (ct.clazz == superClazz) {
            return ct;
        }

        Substitution sub = new Substitution(ct.clazz.getTypeParameters(), ct.arguments);

        Type gsc = ct.clazz.getGenericSuperclass();
        if (gsc != null) {
            ClassType sct = (ClassType) TypeExpr.from(gsc);
            sct = sct.apply(sub);
            ClassType result = getSuperClassType(sct, superClazz);
            if (result != null) {
                return result;
            }
        }

        for (Type gi : ct.clazz.getGenericInterfaces()) {
            ClassType st = (ClassType) TypeExpr.from(gi);
            st = st.apply(sub);
            ClassType result = getSuperClassType(st, superClazz);
            if (result != null) {
                return result;
            }

        }
        return null;
    }

    public static ClassType getSuperClassType(Class clazz, Class superClazz) {
        return getSuperClassType((ClassType) TypeExpr.from(clazz), superClazz);
    }