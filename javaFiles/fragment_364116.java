private static Set<Set<String>> powerset(String[] set) {

    // create the empty power set
    Set<Set<String>> power = new LinkedHashSet<>();

    // get the number of elements in the set
    int elements = set.length;

    // the number of members of a power set is 2^n
    int powerElements = (int) Math.pow(2, elements);

    // run a binary counter for the number of power elements
    for (int i = 0; i < powerElements; i++) {

        // convert the binary number to a string containing n digits
        String binary = intToBinary(i, elements);

        // create a new set
        Set<String> innerSet = new LinkedHashSet<String>();

        // convert each digit in the current binary number to the corresponding element
        // in the given set
        for (int j = 0; j < binary.length(); j++) {
            if (binary.charAt(j) == '1')
                innerSet.add(set[j]);
        }

        // add the new set to the power set
        power.add(innerSet);

    }
    return power;
}