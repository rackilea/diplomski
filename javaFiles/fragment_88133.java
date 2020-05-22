private List<List<Integer>> permutations(List<Integer> input)
{
    List<List<Integer>> permutations = new ArrayList<>();
    // if input's size is one, then there is only one permutation to return
    // wrap it as single entry inside permutations and return 
    if (input.size() == 1) {
        permutations.add(input);
        return permutations;
    }

    // if input's size is more than one, then we need to calc permutations
    // we iterate over the input, each time taking out one cell
    // the remaining cells become tree "under" this cell
    for (int i = 0; i < input.size(); i++) {
        List<Integer> remainingCells = new ArrayList<>(input);
        Integer firstElement = remainingCells.remove(i);
        List<List<Integer>> permutationsUnderFirstElement = permutations(remainingCells);
        for (List<Integer> permutation : permutationsUnderFirstElement) {
            permutation.add(0, firstElement);
            permutations.add(permutation);
        }
    }
    return permutations;
}