GsonBuilder builder = new GsonBuilder();
    builder.registerTypeAdapter(Rated.class, new RatedAdapter());
    Gson gson = builder.create();

    //Let's try it
    Status status = gson.fromJson(json, Status.class);