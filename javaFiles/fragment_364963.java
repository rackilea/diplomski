Map<String, Object> config = new HashMap<String, Object>();
        JsonBuilderFactory factory = Json.createBuilderFactory(config);
        JsonArrayBuilder jsonArrayBuilder = Json.createArrayBuilder();
        for (Integer num: nums) 
            jsonArrayBuilder.add(temp); // Note: adding to the Array Builder here

        // Now add to the final object
        JsonObject obj = factory.createObjectBuilder()
            .add("id", id)
            .add("nums", jsonArrayBuilder)  /* Note the Array Builder is passed in */
            .build();

        // The full object is complete now and can be printed
        // It looks like: { "id":"string", "nums":[4,6,1,2] }
        System.out.println("Object: \n" + obj.toString());