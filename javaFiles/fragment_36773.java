Product coffee = new Product("coffee");
ArrayList<Product> orders1 = new ArrayList<>();
orders.add(coffee);

ArrayList<Product> orders2 = new ArrayList<>();
orders2.add(orders1.get(0)); // "passing"