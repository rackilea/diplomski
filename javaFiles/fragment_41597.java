List<Item> sortedItems = new ArrayList<>();
for (Item item : items) {
    if (item.subRank > -1) {
        sortedItems.add(item);
    }
}

Collections.sort(sortedItems,
                 new Comparator<Item>()
                 {
                     @Override
                     public int compare(Item lhs, Item rhs) {
                         return Integer.compare(lhs.SubRank, rhs.SubRank);
                     }
                 });

int sortedIndex = 0;
for (int i; i < items.size(); i++) {
    if (items.get(i).subRank > -1) {
        items.set(i, sortedItems.get(sortedIndex++));
    }
}