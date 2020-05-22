String json = "[{\"name\":\"a\"},{\"name\":\"b\"}]";

        List<Items> writenItems =  new Gson()
                .fromJson(json, new TypeToken<List<Items>>(){}.getType());
                 writenItems
                .forEach($->
                 System.out.println("name: " + $.getName()));