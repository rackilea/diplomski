final String defaultVal = "Default";
List<String> sortedProfiles = profiles.stream().sorted(
    (o1, o2) -> defaultVal.equals(o1) && defaultVal.equals(o2)
                ? 0
                : (defaultVal .equals(o1)
                   ? -1
                   : (defaultVal .equals(o2) ? 1 : o1.compareTo(o2)))
).collect(Collectors.toList());