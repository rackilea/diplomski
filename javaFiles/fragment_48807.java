public <T extends Battery> ArrayList<T> getLowCost(ArrayList<T> list, double val) {
    ArrayList<T> list2 = new ArrayList<>();
    for (T obj: list) {
        if (obj.getLifeTimeCost() < val) {
            list2.add(obj);
        }
    }
    return list2;
}