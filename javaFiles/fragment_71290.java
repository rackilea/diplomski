public String chooseAvailableMeals(HashMap<String, Integer> allMealsList, String paxType) {

    Random generator = new Random();

    if (Objects.equals(paxType, "adult")) {

        Object[] meals = allMealsList.keySet().toArray();
        Object randomMeal = meals[generator.nextInt(meals.length)];

        Integer value = allMealsList.get(randomMeal);
        if (value != null && value > 0) {
            allMealsList.put(randomMeal, value - 1);
        }
        return (String) randomMeal;
    }

    // you should throw some exception or return some default value here
}