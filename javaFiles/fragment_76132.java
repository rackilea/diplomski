private Set<Enum> getEnumFromType(List<Bean.Var> vars, List<Enum> enums) {
    return vars.stream()
               .map(var -> var.getType().substring(1))
               .map(v -> enums.stream().filter(e -> v.equals(e.getName())).findAny())
               .filter(Optional::isPresent)
               .map(Optional::get)
               .collect(toSet());
}