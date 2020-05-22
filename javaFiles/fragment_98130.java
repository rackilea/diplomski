List<Item> l = new ArrayList<>();
l.add(new Item("GH987", 22, 1992));
l.add(new Item("98KJ", 27, 2000));
...
for (Item it : l)
    System.out.println("Ref: "+item.ref+", size: "+item.size+", date: "+item.date);