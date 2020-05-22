List<List<Integer>> otherOptions = new ArrayList<>();
for (int nodeIdx = 0; nodeIdx < neighbors.size(); nodeIdx++) {
    List<Integer> others = new ArrayList<>(neighbors.get(nodeIdx));
    others.remove(preliminaryAssignments.get(nodeIdx));
    otherOptions.add(others);
}