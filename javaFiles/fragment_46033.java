List<Food> planlist = new ArrayList<Food>();
planlist.add(new Food("Cereal", 20));
planlist.add(new Food("Porrige", 25));
planlist.add(new Food("Fruit", 10));

ArrayAdapter<Food> planAdapter1 = new ArrayAdapter<Food>(this, android.R.layout.simple_spinner_item, planlist);
planAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
spinner2.setAdapter(planAdapter1);