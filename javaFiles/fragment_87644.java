class DegreeComparator implements Comparator<Integer> {
    Integer[][] graph;

    public DegreeComparator(Integer[][] g) {
        graph = g;
    }

    public int compare(Integer c1, Integer c2) {
        return graph[c2].length - graph[c1].length;
    }
}