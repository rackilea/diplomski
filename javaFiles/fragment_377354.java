public static FriendsAPI getInstance() {
            if (service == null) {
                Retrofit retrofit = new Retrofit.Builder()
                        .addConverterFactory(GsonConverterFactory.create())
                        .baseUrl(URL)
                        .build();
               service = retrofit.create(FriendsAPI.class); //Add this line
                return service;

            } else {
                return service;
            }
        }
    }

            } else {
                return service;
            }
        }