Field a; ...
if (a.getType().isArray()) {
    Class<?> elementType = a.getComponentType();
    if (elementType == float.class) { ... // float[]
        ... elementType.getSimpleName() ...;
    }
}