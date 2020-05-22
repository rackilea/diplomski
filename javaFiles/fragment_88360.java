Map<String, Bar> map = new LinkedHashMap<>();
    for (Bar ays : barList) {
        map.put(ays.dayOfPassing, ays);
    }
    barList.clear();
    barList.addAll(map.values());


    for (Bar ays : barList) {

        System.out.println("Unique names are: "+ays.dayOfPassing);
    }