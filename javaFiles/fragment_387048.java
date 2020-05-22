ArrayList<String> restList = new ArrayList<String>();
String restaurantId = null;

//Get multiple restaurant ids
for(int i = 0; i < Utils.cart_map.size(); i++) {

    RestaurantModel restaurant = Utils.cart_restaurants.get(i); // Restaurants details which are presented in cart
    restaurantId = String.valueOf(Integer.parseInt(restaurant.getId()));

    restList.add(restaurantId);
}

// get multiple order ids
for (int j = 0; j < orders.length(); j++) {

    String rest_id = restList.get(j);
    order_id = orders.getString(j);

    ordersHashMap.put(rest_id, order_id);
}