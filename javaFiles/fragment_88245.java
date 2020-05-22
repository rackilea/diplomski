public List<Integer> getLocationsOfChar(String input, char c) { 
    List<Integer> locations = new ArrayList<Integer>();
    int index = -1;
    int startAt = 0;
    while ((index = input.indexOf(c, startAt)) != -1) {
        locations.add(index);
        startAt = index+1;
    }
    return locations;
}