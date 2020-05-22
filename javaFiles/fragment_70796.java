Set<String> jcfTargetTables = measure.getConditionMap().values()
    .stream()
    .map(Condition::getJoinConditionFilter)
    .filter(jcf -> jcf!=null)
    .map(JoinConditionFilter::getTableMapping)
    .flatMap(map -> map.values().stream()).collect(Collectors.toSet());;