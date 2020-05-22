JsonObject value = Json.createObjectBuilder()
                .add("items", Json.createArrayBuilder()
                        .add(Json.createObjectBuilder()
                                .add("id", 1)
                                .add("name", "Item1")
                                .add("bool", true)
                                .add("reserveItems", Json.createArrayBuilder())
                        )
                        .add(Json.createObjectBuilder()
                                .add("id", 2)
                                .add("name", "Item2")
                                .add("bool", false)
                                .add("reserveItems", Json.createArrayBuilder())
                        )
                )
               .add("length", 687)
               .build();

               System.out.println(value);