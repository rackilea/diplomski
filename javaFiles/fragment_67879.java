String ids = "1,2,3,4,5";
    String locations = "loc1,loc2,loc3,loc4,loc5";

    String[] idArr = ids.split(",");
    String[] locationArr = locations.split(",");

    Map<String, String> data = new HashMap<>();

    for (int i = 0; i <= locationArr.length - 1; i++) {
        data.put(idArr[i], locationArr[i]);

        System.out.println("<a href=" + "updateLocation/" + idArr[i] + ">" + locationArr[i] + "</a>");

    }
    System.out.println("-----map data--------" + data);