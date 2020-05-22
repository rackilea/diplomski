int userOverlap = ... // Get user overlap
int minLength = Math.min(stringOne.length(), stringTwo.length());
for (int overlap = userOverlap  ; overlap <= minLength; overlap++) {
    if (testOverlap(stringOne, stringTwo, overlap)) {
        return true;
    }
}
return false;

private static bool testOverlap(String a, String b, int overlap) {
    ... // This is your method that tests for one specific overlap
}