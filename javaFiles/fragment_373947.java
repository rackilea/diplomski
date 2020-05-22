Map<KeyClass, CustomClass> map = new HashMap<>();

List<?> data = map.values().stream()
                    .map(CustomClass::getList)
                    .flatMap(List::stream)
                    .collect(Collectors.toList());