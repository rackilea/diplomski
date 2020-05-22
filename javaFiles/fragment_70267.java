Set<Item> items = new HashSet<Item>(c.getCount());
if (c.moveToFirst()) {
            do {
               Item i = new Item(select(c.getString(0), c.getString(1), c.getString(2));
               set.add(i);
            } while (c.moveToNext());
         }
         if (!c.isClosed()) {
            c.close();
         }