TypeElement declaringClass =
    (TypeElement) method.getEnclosingElement();

String className =
//            also getSimpleName()
    declaringClass.getQualifiedName().toString();