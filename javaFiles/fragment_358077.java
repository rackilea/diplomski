RestAdapter restAdapter = new RestAdapter.Builder()
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .setConverter(new GsonConverter(new GsonBuilder()).create()))
                .setEndpoint("your api end point goes here")
                .build(); 
YourAPI api = restAdapter.create(YourAPI.class);