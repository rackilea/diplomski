Set<Integer> used = new HashSet<>(usedElements);  // maybe use a set in the
                                                  // first place?

List<Integer> newElements = 
                       new ArrayList<>(elements.size() - used.size());

for (int i = 0; i < elements.size(); i++) {
    if (!used.contains(i))
        newElements.add(elements.get(i));
}

elements = newElements;