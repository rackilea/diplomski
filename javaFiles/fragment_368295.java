class PopulationComparator
implements Comparator<Map<String, String>> {
    @Override
    public int compare(Map<String, String> map1, Map<String, String> map2) {
        final Long pop1 = Long.valueOf(map1.get("population"));
        final Long pop2 = Long.valueOf(map2.get("population"));

        return pop1.compareTo(pop2);
   }
}