ScrollableResults itemCursor = session.createQuery("from Item").scroll();
int count=0;

while ( itemCursor.next() ) {
  Item item = (Item) itemCursor.get(0);
  modifyItem(item);
  if ( ++count % 100 == 0 ) {
    session.flush();
    session.clear();
  }
}