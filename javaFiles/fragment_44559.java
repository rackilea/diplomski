public List<Fruit> getFruits() {
     List<Fruit> fruits = new ArrayList<Fruit>();
     for (Map<String, String> m : data) {
           Fruit f = new Fruit();
           f.setApple(m.get(“apple”));
           f.setMango(m.get(“mango”));
           f.setBanana(m.get(“banana”));
           f.setOrange(m.get(“orange”));
           fruits.add(f);
     }
     return fruits;
}