LocalDate min = customObjects.stream()
                             .map(CustomObject::getDateTime)
                             .min(Comparator.naturalOrder());
List<CustomObject> objs = customObjects.stream()
                             .filter(c -> min.equals(c.getDateTime()))
                             .collect(Collectors.toList());