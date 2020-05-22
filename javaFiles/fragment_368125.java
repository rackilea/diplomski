Set<Element> current = elementMap.get(i.group);
if (current == null) {
    current = new TreeSet<>(new ElementNumComparator());
    elementMap.put(i.group, current);
}
current.add(i);