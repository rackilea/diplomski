List<Food> foodList=db.readFoodData(); // here your database read opration and give list of food
    FoodAdapter foodAdapterSandwich = new FoodAdapter(foodList,this);


    RecyclerView foodRecyclerView = findViewById(R.id.sandwich_recycler_view);
    foodRecyclerView.setLayoutManager(new LinearLayoutManager(this));

    foodRecyclerView.setAdapter(foodAdapterSandwich);
    foodAdapterSandwich.notifyDataSetChanged();