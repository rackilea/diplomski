Map<Integer, PriceListManager> map = new HashMap<Integer, PriceListManager>();

    for (PriceListManager manager : yourArrayList) {

        if (!map.contains(manager.getPriceListID())) {
            map.put(manager.getPriceListID(), manager);
        }

        if (manager.isUser()) {
            map.get(manager.getPriceListID()).setIsUser(true);
        }

        if (manager.isManager()) {
            map.get(manager.getPriceListID()).setIsManager(true);
        }
    }

    List<PriceListManager> newList = new ArrayList<PriceListManager>();
    newList.addAll(map.values());

    // Do stuff with newList....