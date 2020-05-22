public class UniqueSplitter<T> {

    public Map<T, List<T>> filterOutElements(final List<?> theCandidateList) {
        final Map<T, List<T>> candidateMap = new HashMap<>();
        for(Object element : theCandidateList) {
            if(candidateMap.containsKey(element)) {
                candidateMap.get(element).add((T) element);
            } else {
                final List<T> elementList = new ArrayList<>();
                elementList.add((T) element);
                candidateMap.put((T)element, elementList);
            }
        }
        return candidateMap;
    }
}