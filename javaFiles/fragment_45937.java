elementsTable.sortPolicyProperty().set(t -> {
    Comparator<Row> comparator = (r1, r2) -> {
        int n1 = of.wrap.els.getElement(toZ(r1.getSymbol())).getZ();
        int n2 = of.wrap.els.getElement(toZ(r2.getSymbol())).getZ();
        return n1 > n2 ? 1
        : n1 < n2 ? -1
        : n1 == n2 ? 0
        : t.getComparator() == null ? 0 //no column sorted: don't change order
        : t.getComparator().compare(r1, r2); //columns are sorted: sort accordingly
        };
        FXCollections.sort(elementsTable.getItems(), comparator);
    return true;
});