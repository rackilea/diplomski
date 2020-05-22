private int similarityCount (String one, String two) {

    if (one == null && two == null) {
        return 1;
    } 

    if (one == null) {
        return 2;
    } 

    if (two == null) {
        return 3;
    } 

    if (isMatch(one, two)) {
        return 4;
    }
    return 5;
}