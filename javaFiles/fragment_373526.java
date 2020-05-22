String json = "{ ... json string ... }";
Gson gson = new Gson();
Models model = gson.fromJson(json, Models.class);


for (Models.Container container : model) {

    String innerJson = gson.toJson(container.object);

    switch(container.type){
        case 1:
            Models.Type1Object type1Object = gson.fromJson(innerJson, Models.Type1Object.class);
            // do something with type 1 object...                                
            break;
        case 2:
            String[] type2Object = gson.fromJson(innerJson, String[].class);
            // do something with type 2 object...
            break;
        case 3:
            Models.Type3Object[] type3Object = gson.fromJson(innerJson, Models.Type3Object[].class);
            // do something with type 3 object...
            break;
        case 4:
            Models.Type4Object type4Object = gson.fromJson(innerJson, Models.Type4Object.class);
            // do something with type 4 object...
            break;

    }
}