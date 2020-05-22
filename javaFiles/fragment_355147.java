public void showHouses() {
    Iterator<House> itr = houseList.iterator();
    while (itr.hasNext()) {
        System.out.println(itr.next().toString());
    }
}