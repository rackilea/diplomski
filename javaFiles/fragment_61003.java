List<String> listOfRemovedItems = new LinkedList<>();
    Iterator iterator = originalList.iterator();
    while (iterator.hasNext()) {
        String s = iterator.next().toString();
        if ("meets your condition") {
            listOfRemovedItems.add(s);
            iterator.remove();
        }
    }