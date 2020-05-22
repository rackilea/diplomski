Map<Member, String[]> map = this.parameterNamesCache.get(declaringClass);
if (map == null) {
    map = inspectClass(declaringClass);
    this.parameterNamesCache.put(declaringClass, map);
}
if (map != NO_DEBUG_INFO_MAP) {
    return map.get(originalMethod);
}