List<Restaurant> searchRestaurant(List<Restaurant> allRestaurants, String name, String area, String phone, String category) {
    List<Restaurant> matches = new ArrayList<Restaurant>();
    for (Restaurant restaurant : allRestaurants) {
        if (restaurant.meetsCriteria(name, area, phone, category)) {
            matches.addRestaurant(allRestaurants.get(i));
        }
    }
    return matches;
}