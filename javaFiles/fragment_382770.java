while(sc.hasNext()) {
    String color = sc.next();
    if(sc.hasNext()) {
        String name = sc.next();
        Fruit fruit = new Fruit(color, name);
        System.out.println(fruit);
    }
}