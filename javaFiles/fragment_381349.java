ArrayAdapter<Food> planAdapter1 = new ArrayAdapter<Food>(this,
        android.R.layout.simple_spinner_item, new Food[]{
        new Food(1, "Toast"),
        new Food(99, "Cereal"),
        new Food(53, "Fruit"),
        new Food(153, "Yogurt")
});