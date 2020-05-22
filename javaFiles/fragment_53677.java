Set<String> stringPermutations = new HashSet<>(Collections.singletonList(s));

for (Permutation permutation : permutationList) {
    Set<String> result = permutation.applyPermutations(stringPermutations);
    stringPermutations.addAll(result);
}