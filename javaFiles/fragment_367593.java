} catch (Exception e) {
    Class superclass = type.getSuperclass();
    if (superclass != null) {
        field = getField(superclass, fieldName);
    }
}