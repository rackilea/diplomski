Document firstElementInArray = collection.find(filter).first()
        // read the details as an Array 
        .get("details", ArrayList.class)
        // focus on the first element in the details array
        .get(0);

    String name = firstElementInArray.getString("name");