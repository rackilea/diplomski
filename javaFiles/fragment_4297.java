Collection<Option> options = group.getOptions();
assert(options != null);
assert(settingName != null);
newOptions.addAll(options.stream()
    .filter(o -> settingName.equalsIgnoringCase(o.getName()))
    .collect(Collectors.toList());