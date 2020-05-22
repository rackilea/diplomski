List <String> allPermutationsOfSubsequences( Set <Character> chars ) {

    Set < Set <Character> > powerSetOfChars = generatePowerSet ( chars );

    List <String> permutations = new ArrayList <String> ();

    for (Set <Character> subsequence : powerSetOfChars)
        permutations.addAll( generatePermutations ( subsequence ) );

    return permutations;
}

Set <Set <Character>> generatePowerSet ( Set <Character> set ) {
    Set < Set <Character> > powerSet = new HashSet < Set <Character> > ();
    if (set.size() == 0) {
        powerSet.add(new HashSet <Character> ());
        return powerSet;
    }

    Character anElement = set.iterator().next();
    set.remove(anElement);

    for (Set <Character> subset : powerSet(set)) {
        Set <Character> setWithElement = new HashSet <Character> ();
        setWithElement.add(anElement);
        setWithElement.addAll(subset);
        powerSet.add(newSet);
        powerSet.add(subset);
    }

    set.add(anElement);

    return powerSets;
}

//Generates a list of permutations of the characters provided in the set.
List <String> generatePermutations ( Set <Character> chars );