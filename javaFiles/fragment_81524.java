ArrayList<Place> place_list; // your list of places here
ArrayList<Element> element_list; // your list of elements here
HashMap<Place,ArrayList<Place>> parent_map = new HashMap<Place,ArrayList<Place>>;
ArrayList<Place> a;

for (int i = 0; i < place_list.size() - 1; i++) {
    Place place1 = place_list.get(i);
    for (int j = i + 1; j < place_list.size(); j++) {
        Place place2 = place_list.get(j);
        int dist = getDistance(place1, place2);
        if (dist > DISTANCE_THRESHOLD) continue;
        // if this place is within range,
        // add parent place to its list and put/update it to the map
        a = parent_map.get(place2);
        if (a == null) a = new ArrayList<Place>();
        a.add(place1);
        parent_map.put(place2, a);
    }
}