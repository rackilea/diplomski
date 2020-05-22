Set<String> stringPermutations = new HashSet<>();

for (Permutation permutation : permutationList) {
    Set<String> result = permutation.applyPermutations(Collections.singletonList(s));
    stringPermutations.addAll(result);
}

stringPermutations.addAll(Collections.singletonList(s));