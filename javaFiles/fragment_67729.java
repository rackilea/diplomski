String str=  getIntent().getStringExtra("list");
    Gson gson = new Gson();

    Type entityType = new TypeToken< LinkedHashMap<String, String>>(){}.getType();
    data = gson.fromJson(str, entityType);

    String jsonList = gson.toJson(data, LinkedHashMap.class);

    Log.e("list", ""+jsonList);
    Log.e("Size", ""+data.size());