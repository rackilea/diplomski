Table<Integer, String, String> titlesAndPlacesById = TreeBasedTable.create();
titlesAndPlacesById.put(1, "T1", "P1");
titlesAndPlacesById.put(2, "T2", "P2");
titlesAndPlacesById.put(3, "T3", "P3");

for(Table.Cell<Integer, String, String> cell : titlesAndPlacesById.cellSet()){
  System.out.println("ID : " + cell.getColumnKey() + " Title : " + cell.getRowKey() + ", Place: " + cell.getValue());
}