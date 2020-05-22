public Object get(String name, ObjectFactory objectFactory) {
    RequestAttributes attributes = RequestContextHolder.currentRequestAttributes();
    Object scopedObject = attributes.getAttribute(name, getScope());
    if (scopedObject == null) {
        scopedObject = objectFactory.getObject();
        attributes.setAttribute(name, scopedObject, getScope());
    }
    return scopedObject;
}