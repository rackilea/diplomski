table.sortPolicyProperty().set(t -> {
    Comparator<Row> comparator = (r1, r2) -> 
         r1 == TOTAL ? 1 //TOTAL at the bottom
       : r2 == TOTAL ? -1 //TOTAL at the bottom
       : t.getComparator() == null ? 0 //no column sorted: don't change order
       : t.getComparator().compare(r1, r2); //columns are sorted: sort accordingly
    FXCollections.sort(t.getItems(), comparator);
    return true;
});