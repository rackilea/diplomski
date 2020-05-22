ResultSet rs = stmt.executeQuery(query);
    Map<String, String> resultMap = new HashMap<String, String>();
    while (rs.next()) {
        String product = rs.getString("product");
        String itemCode = rs.getString("itemcode");
        String desc = rs.getString("Desc");
        String mapValue = "";
        if (resultMap.containsKey(product)) {
            mapValue = resultMap.get(product) + " " + itemCode + " " + desc ;
        }
        resultMap.put(product, mapValue);
    }

    int itemCount = 1;
    for (Map.Entry<String, String> entry : resultMap.entrySet()) {
        System.out.println(entry.getKey() + "  item" + itemCount + " " + entry.getValue());
        itemCount++;
    }