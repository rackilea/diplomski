Iterator<Integer> itID = ID.iterator();
while (itID.hasNext()) {
    // Every time you ask for an iterator, you obtain a new one.
    Iterator<String> itTable = Table.iterator();
    Iterator<String> itColumn = Column.iterator();
    int i = itID.next();
    System.out.println(i);
    while(itTable.hasNext()){
        String SQL = "select " + itColumn.next() + " from " +  itTable.next() + " where id=" + i;
        System.out.println(SQL);
    }
}