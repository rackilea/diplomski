private Set<Enum> getEnumFromType(List<Bean.Var> vars, List<Enum> enums) {
    Map<String, Enum> enumsName = enums.stream().collect(toMap(Enum::getName, e -> e, (e1, e2) -> e1));
    return vars.stream()
               .map(var -> var.getType().substring(1))
               .map(enumsName::get)
               .filter(Objects::nonNull)
               .collect(toSet());
}