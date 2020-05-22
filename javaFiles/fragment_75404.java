List<Map<String, String>> mapList = new ArrayList<>();
    if (myObjects != null && myObjects.length > 0) {
        for (myObject myObject : myObjects) {
            Map<String, String> mapItem = new HashMap<>();
            if (myObject != null /*&& Other Checks on FirstName and LastName*/) {
                mapItem.put("firstName", myObject.getFirstName());
                mapItem.put("lastName", myObject.getLastName());
                mapList.add(mapItem);
            }
        }
    }