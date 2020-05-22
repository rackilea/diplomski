for (Integer input : inputs) {
    Set<SubList> newSums = new HashSet<>();

    // loop over all sums so far                        
    for (SubList sum : sums) {
        List<Integer> newSubList = new ArrayList<>(sum.subList);
        newSubList.add(input);
        SubList newSum = new SubList(sum.size + input, newSubList);         

        // ignore too big sums
        if (newSum.size <= K) {
            newSums.add(newSum);

            // update optimum                       
            if (newSum.size > opt) {
                opt = newSum;
            }
        }
    }

    sums.addAll(newSums);
}