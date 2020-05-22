public void showHouses() {
    Iterator<House> itr = houseList.iterator();
    while (itr.hasNext()) {
        House house = itr.next();
        System.out.println(house);
        // or, say: System.out.println(house.getAddress());
    }
}