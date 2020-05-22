public void addWeather() {
        weather3 = (Spinner) findViewById(R.id.spinner5);
        String[] arr = new String[]{"Sunny","Cloudy","Rainy","Thunderstorm"};
        List<String> list = new ArrayList<String>();
        String weather = c.getString(c.getColumnIndexOrThrow(MyDatabaseHelper.Weather));
        list.add(weather);
        for(String s:arr){
            if(!list.contains(s)){
                list.add(s);
            }
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(UpdatePage.this, android.R.layout.simple_spinner_dropdown_item, list);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        weather3.setAdapter(adapter);
    }