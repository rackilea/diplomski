public static List<ElementToSort> sort(final List<ElementToSort> testData) {
    // minimum date associated to each pio
    final Map<Integer, Integer> minDates = new HashMap<Integer, Integer>();

    for (final ElementToSort voy : testData) {
        if (!minDates.containsKey(voy.getPio()) || minDates.get(voy.getPio()) > voy.getDate()) {
            minDates.put(voy.getPio(), voy.getDate());
        }
    }

    // copy testData in case it's read-only
    final List<ElementToSort> sortedData = new ArrayList<ElementToSort>(testData);

    Collections.sort(sortedData, new Comparator<ElementToSort>() {
        @Override
        public int compare(ElementToSort voy1, ElementToSort voy2) {
            int cmp = minDates.get(voy1.getPio()) - minDates.get(voy2.getPio());
            // just in case we have different pio with the same date
            if (cmp == 0) {
                cmp = voy1.getPio() - voy2.getPio();
            }
            if (cmp == 0) {
                cmp = voy1.getDate() - voy2.getDate();
            }
            return cmp;
        }
    });

    return sortedData;
}