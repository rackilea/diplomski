protected boolean isAllowed(String field) {
    String[] allowed = getAllowedFields();
    String[] disallowed = getDisallowedFields();
    return ((ObjectUtils.isEmpty(allowed) || PatternMatchUtils.simpleMatch(allowed, field)) &&
            (ObjectUtils.isEmpty(disallowed) || !PatternMatchUtils.simpleMatch(disallowed, field)));
}