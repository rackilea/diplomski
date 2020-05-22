public static void main(String[] args) {

    // ...

    range(0, rooms.size()).forEach(i -> rooms.get(houses.get(i).getCode())
            .setName(houses.get(i).getName()));

    range(0, rooms.size()).forEach(i -> rooms.get(houses.get(i).getCode())
            .setSize(houses.get(i).getSize()));

}