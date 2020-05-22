private static List<Integer> allSquares(List<BaseMultiplicity> elems) {
    /* Base case: If the list is empty, there's only one square. */
    if (elems.isEmpty()) {
        return Collections.singletonList(1);
    }

    /* Recursive case: Compute the answer for the rest of the list. */
    List<BaseMultiplicity> rest = new LinkedList<BaseMultiplicity>(elems);
    rest.remove(0);
    List<Integer> recResult = allSquares(rest);

    /* Now, for each even power of this number, add appropriately-scaled
     * copies of the recursive solution to the result.
     */
    List<Integer> result = new ArrayList<Integer>();
    for (int i = 0, base = 1; i < elems.get(0).multiplicity; 
         i += 2, base *= elems.get(0).prime)
        for (Integer elem: recResult)
            result.add(elem * base * base);

    return result;
}