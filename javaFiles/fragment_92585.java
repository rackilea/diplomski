// instance of javax.lang.model.util.Types
protected final Types types;

// instance of javax.lang.model.util.Elements
protected final Elements el;

// TypeMirror for java.lang.Object
protected final TypeMirror theObject = ...

private static final TYPE_REFINER = new DeclaredTypeRefiner();

private class DeclaredTypeRefiner extends TypeKindVisitor6<DeclaredType, TypeMirror> {
  @Override
  public DeclaredType visitDeclared(DeclaredType type, TypeMirror desirableParent) {
    if (types.isSameType(types.erasure(type), desirableParent)) {
      return type;
    }

    return null;
  }

  @Override
  public DeclaredType visitUnknown(TypeMirror typeMirror, TypeMirror typeMirror2) {
    return defaultAction(typeMirror, typeMirror2);
  }

  @Override
  protected DeclaredType defaultAction(TypeMirror type, TypeMirror desirableParent) {
    if (types.isSameType(type, theObject)) {
      return null;
    }

    final List<? extends TypeMirror> superTypes = types.directSupertypes(type);

    for (TypeMirror parent : superTypes) {
        final DeclaredType discovered = visit(parent, desirableParent);

      if (discovered != null) {
         return discovered;
      }
    }

    return null;
  }
}

public TypeMirror getTypeArg(TypeMirror actual, TypeMirror base, int idx) {
  DeclaredType found = TYPE_REFINER.visit(actual, types.erasure(base));

  return found.getTypeArguments().get(idx);
}