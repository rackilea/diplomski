....
 Gson gson = new Gson();

    MyGson myGson = gson.fromJson(str, MyGson.class);

    List<Item> items = myGson.getData().getItems();

    if(items.size()>0){
        Item item = items.get(0);

        String myStr = item.getContent().get(1);

        System.out.println(myStr);
    }