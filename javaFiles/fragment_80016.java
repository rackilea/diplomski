Map<String, Object> value = new HashMap<>();
    value.put("username", username);

    Map<String, Object> childUpdates = new HashMap<>();
    childUpdates.put("/path1/" + key, value);
    childUpdates.put("/path2/" + key, value);
    childUpdates.put("/path3/" + key, value);



    mDatabase.updateChildren(childUpdates);