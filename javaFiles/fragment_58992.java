protected Set<Object> createEntitySetFromRelationshipEndNodes(Object entity, final MappingPolicy mappingPolicy, final Class<?> relatedType) {
    final Iterable<Node> nodes = getStatesFromEntity(entity);
    final Set<Object> result = new HashSet<Object>();
    for (final Node otherNode : nodes) {
        Object target = template.createEntityFromState(otherNode, relatedType, mappingPolicy);
        result.add(target);
    }
    return result;
}