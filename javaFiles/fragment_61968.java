Order ord = New ord("my first order");
Item item = New Item("tv",10);

item.setOrder(ord);

Set<Item> items= new HashSet<Item>();
items.add(item);
ord.setItems(items);

em.persist(ord);