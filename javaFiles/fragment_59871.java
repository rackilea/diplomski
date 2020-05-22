return methods.stream().anyMatch(mthd -> {
    if (!method.getName().equals(mthd.getName())) {
        return false;
    }
    if (!method.getReturnType().isAssignableFrom(mthd.getReturnType())) {
        return false;
    }
    final Class<?>[] parameterTypes = method.getParameterTypes();
    if (mthd.getParameterTypes().length != parameterTypes.length) {
        return false;
    }
    for (int i = 0; i < parameterTypes.length; i++) {
        if (!parameterTypes[i].equals(mthd.getParameterTypes()[i])) {
            return false;
        }
    }
    return true;
});