Map<Integer, Tst> resultPerYear = new HashMap<>();
for (Tst tst : listTotal) {
    Tst resultForYear = resultPerYear.get(tst.getYear());
    if (resultForYear == null) {
        resultPerYear.put(tst.getYear(), tst);
    }
    else {
        resultForYear.merge(tst);
    }
}
Set<Tst> result = resultPerYear.values();