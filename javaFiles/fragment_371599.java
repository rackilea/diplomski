Gson gson = new Gson();
    MainResponse mainResponse = gson.fromJson(response, MainResponse.class);
    List<Race> races = mainResponse.getRaces();
    for (Race race : races) {
        Log.e("TEST","Race id : " + race.getId());
        Log.e("TEST","Race Name : " + race.getName());
    }