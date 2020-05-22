ListView lvCountries = (ListView)findViewById(R.id.lvCountries);
ArrayList<Country> countries;
countries = new ArrayList<>();
countries.add(new Country("Australia", 100, "Canberra", "English", "Dollars", R.drawable.australia));
countries.add(new Country("China", 5771876, "Beijing", "Chinese", "Renminbi", R.drawable.china));
countries.add(new Country("Germany", 126860301, "Berlin", "German", "Euros", R.drawable.germany));
countries.add(new Country("India", 60550075, "New Delhi", "Indian", "Rupees", R.drawable.india));
countries.add(new Country("UK", 100, "London", "English", "GBP", R.drawable.uk));


CustomAdapter customAdapter=new CustomAdapter(countries,getApplicationContext());
lvCountries.setAdapter(customAdapter);