if (inventoryList.size() > 0) {
    int best = 0;
    int i  = 1;
    while (i < inventoryList.size()) {
        double cost = inventoryList.get(i).getCost();
        if (cost < inventoryList.get(best).getCost()) {
            best = i;
        }
        i++;
    }
    return inventoryList.get(best);
} else {
    return "N/A";
}