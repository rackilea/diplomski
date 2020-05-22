LinkedList<Customer> person = new LinkedList<>();
    LinkedList<String> item = new LinkedList<String>();
    LinkedList<String> item2 = new LinkedList<String>();

    person.add(new Customer("John"));
    person.add(new Customer("Amy"));
    person.add(new Customer("Bob"));
    person.add(new Customer("Michael"));


    item.add("Eggs");
    item.add("Bread");
    item.add("Ham");

    item2.add("Toilet roll");
    item2.add("Eggs");

    person.get(0).setItemsBought(item);
    person.get(1).setItemsBought(item2);

    System.out.println(person);