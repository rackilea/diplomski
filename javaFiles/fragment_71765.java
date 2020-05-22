List<List<Integer>> otherOptions = new ArrayList<>();
Iterator<Integer> prelimIter = preliminaryAssignments.iterator();
for (Iterator<List<Integer>> neighborIter = neighbors.iterator(); neighborIter.hasNext(); ) {
    List<Integer> others = new ArrayList<>(neighborIter.next());
    others.remove(prelimIter.next());
    otherOptions.add(others);
}