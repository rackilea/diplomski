public String getDishNameByType(String dishType) {  
    for (Dish dish : dishesList) {
        if ((dishType.equals(dish.getDishType()))) {
            return dish.getDishName();
        }
    }
    return null;    
}