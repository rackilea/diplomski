Iterator<Map<String, String>> iterator = placesListItems.iterator();
while (iterator.hasNext()) {
    Map<String, String> map = iterator.next();
    for (String value : map.values()) {
        if (duplicateList.contains(value)) { // You can iterate over duplicateList, but List.contains() is a nice shorthand.
            iterator.remove(); // Removing the map from placesListItems
            break; // There is no point iterating over other values of map
        }
    }
}