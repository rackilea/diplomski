//adding to the preferences:

    hsMap.put("freeMode", json.toJson( hsFreeMode ) );


    //and then:

    Gdx.app.log("data print", "the free mode value is " + ( (String[])json.fromJson(ArrayList.class, String[].class, (String)data.get("freeMode") ).get(0) )[0] );