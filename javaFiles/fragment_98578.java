public class ListMergeByRef {

    public Map<Integer, List<Integer>> refMap = new HashMap<Integer,List<Integer>>();
    public ListMergeByRef(List<Integer> reference) {
        int elementIndex = 0;
        for (Integer element:reference) {
            List<Integer> refListPerElement = refMap.get(element);
            if (refListPerElement == null) {
                refListPerElement = new ArrayList<Integer>();
            }
            refListPerElement.add(elementIndex);
            elementIndex++;
            refMap.put(element, refListPerElement);
        }
    }

    public List<Integer> mergeLists (List<Integer> first, List<Integer> second) {
        int firstIndex = 0;
        int secondIndex = 0;
        List<Integer> merged = new ArrayList<Integer>();
        while (firstIndex < first.size() || secondIndex < second.size()) {
            if (firstIndex == first.size()) {
                merged.addAll(second.subList(secondIndex, second.size()));
                return merged;
            } else if (secondIndex == second.size()) {
                merged.addAll(first.subList(firstIndex, first.size()));
                return merged;
            } 

            if (first.get(firstIndex).equals(second.get(secondIndex))){
                merged.add(first.get(firstIndex));
                firstIndex++;
                secondIndex++;
            }
            else if (isElementAllowedBeforeOther(first.get(firstIndex), second.get(secondIndex))) {
                merged.add(first.get(firstIndex));
                firstIndex++;
            } else {
                merged.add(second.get(secondIndex));
                secondIndex++;
            }
        }
        return merged;
    }

    public boolean isElementAllowedBeforeOther(Integer firstElement, Integer secondElement) {
        List<Integer> firstElementIndexes = refMap.get(firstElement);
        List<Integer> secondElementIndexes = refMap.get(secondElement);
        if (firstElementIndexes == null || firstElementIndexes.isEmpty()) return false;
        if (secondElementIndexes == null || secondElementIndexes.isEmpty()) return true;
        if (firstElementIndexes.get(0) < secondElementIndexes.get(secondElementIndexes.size()-1)) return true;
        return false;
    }

    public static void main(String[] args) {
        List<Integer> ref = Arrays.asList(new Integer[] {1,2,3,4,5,6,4,7,8});
        List<Integer> first = Arrays.asList(new Integer[] {2,3,4,5,7});
        List<Integer> second = Arrays.asList(new Integer[] {4,7,8});
        ListMergeByRef merger = new ListMergeByRef(ref);
        List<Integer> mergedList = merger.mergeLists(first, second);
        for (Integer element: mergedList) {
            System.out.print(element+" ");
        }
        System.out.println();
    }