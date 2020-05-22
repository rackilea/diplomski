public Set<String> recursivePermutations(List<Set<String>> sets){
    if(sets.size() ==2){
        return getPermutations(sets.get(0), sets.get(1));
    }else{
        return getPermutations(sets.get(0),recursivePermutations(sets.sublist(1,sets.size()-1));
    }
}