Map<Integer, String> mappaQuery = new HashMap<Integer, String>();
    for (String item : arrayQuery) {
        String split[] = item.split("\\|");
        if (split.length >= 2) {
            if (item.contains("%2C")) {
                mappaQuery.put(Integer.valueOf(split[0]), URLDecoder.decode(split[1], "UTF-8"));
            } else {
                mappaQuery.put(Integer.valueOf(split[0]), split[1]);
            }
        } else if (split.length == 1) {
            mappaQuery.put(Integer.valueOf(split[0]), "|");
        }
    }