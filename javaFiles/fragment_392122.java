private List<Integer> getSelectedRowSums(
        int sommerWinter,
        int urlaubsart,
        int region,
        int anreise,
        int[][] destiBewertung
) {
    List<Integer> selectedRowSumList = new ArrayList<>();
    for (int[] columns : destiBewertung) {
        if (columns[0] == sommerWinter) {
            int sum = columns[urlaubsart] + columns[region] + columns[anreise];
            selectedRowSumList.add(sum);
        }
    }
    return selectedRowSumList;
}