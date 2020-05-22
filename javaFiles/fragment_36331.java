Map<String, Map<String, Long>> map = new HashMap<>();

    //...

    for (Entry<String, Map<String, Long>> mapEntry : map.entrySet()) {
        String mapKey = mapEntry.getKey();
        Map<String, Long> submap = mapEntry.getValue();
        for (Entry<String, Long> submapEntry : submap.entrySet()) {
            String submapKey = submapEntry.getKey();
            Long submapList = submapEntry.getValue();

            //TODO: do whatever you want with these items.
        }
    }