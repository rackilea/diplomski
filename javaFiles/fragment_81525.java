HashMap<Place,Element> used_place_map = new HashMap<Place,Element>(); // key is place, value is assigned element
ArrayList<Element> tmp_element_list;

for (i = 0; i < place_list.size(); i++) {
    Place place = place_list.get(i);
    a = parent_map.get(place);
    if (a == null) { // this place has no parents, use elements freely
        tmp_element_list = element_list;
    } else { // if it has parents, they have already registered their elements in used_place_map
        tmp_element_list = new ArrayList<Element>();
        // create list of available elements, lame
        for (j = 0; j < element_list.size(); j++) tmp_element_list.add(element_list.get(j));
        // now reduce it, very lame, sorry
        for (Place pl : a) {
            Element used_element = used_place_map.get(pl);
            for (j = 0; j < tmp_element_list.size(); j++) {
                if (used_element.equals(tmp_element_list.get(j)) {
                    tmp_element_list.remove(j);
                    break;
                }
            }
        }
    }

    // finally, get the random index on (probably reduced) array
    int element_id = Random.nextInt(tmp_element_list.size());
    Element element = element_list.get(element_id);
    // store our choice as future parent
    used_place_map.put(place, element);
}