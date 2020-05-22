IdentityHashMap<Item,Item> m = new IdentityHashMap<Item,Item>(itemset.size());

for (Item i : itemset)
    m.put(i.previousItem, i);

Item i = m.get(null);

while (i != null) {
    result.add(i);

    i = m.get(i);
}