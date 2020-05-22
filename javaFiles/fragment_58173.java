String chooseElementProperty(List<Element> elements, List<String> prefs) {
  // Iterates the list and creates a set of all the property values.
  // example: [{property: 'A'}, {property: 'B'}] -> {'A', 'B'}
  Set<String> propertyValues = pluckPropertyValues(elements);

  for (String s: prefs) {
      if (propertyValues.contains(s))
          return s;
  }
  throw new IllegalArgumentException("Invalid input!");
}