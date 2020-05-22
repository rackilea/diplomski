em.getTransaction().begin();
Item item = new Item("A Jar");
// item.addCost(new Date(), 7);
ItemCost itemcost = new ItemCost(new Date(), 7);
itemcost.setItem(item); //owning side
item.getCosts().add(itemcost); //non-owning side
em.persist(item);
em.getTransaction().commit();