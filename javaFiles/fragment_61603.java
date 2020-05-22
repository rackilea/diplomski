public static boolean implementsInterface (TypeElement myTypeElement, TypeMirror desiredInterface) {
    for (TypeMirror t : myTypeElement.getInterfaces())
        if (processingEnv.getTypeUtils().isAssignable(t, desiredInterface))
            return true;
    return false;
}