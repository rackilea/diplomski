public FoodItem getFoodItem(Map<String, FoodItem> map, String foodItemId){
    if (foodItemId == null || foodItemList == null || foodItemList.isEmpty()) {
        return null;
    }
    return map.get(foodItemId); // returns null if it doesn't exists
}