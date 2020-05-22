public List<String> generatePermutations(int numOnes, int stringLength) {
    final StringBuilder sb = new StringBuilder();
    final List<String> result = new ArrayList<>();
    distributeOnes(numOnes, stringLength, sb, result);
    return result;
}

private void distributeOnes(int numOfOnesRemaining, int positionsToFill, StringBuilder sb,
    List<String> result)
{
    if (numOfOnesRemaining == 0) {
        while (positionsToFill-- > 0) {
            sb.append('0');
        }
        result.add(sb.toString());
        return;
    }
    final int lastPos = positionsToFill - numOfOnesRemaining;
    final int sbLength = sb.length();
    for (int i = 0; i <= lastPos; ++i) {
        // put i zeros
        for (int j = 0; j < i; ++j) {
            sb.append('0');
        }
        // put in the next one
        sb.append('1');
        // recurse with one less one and i+1 fewer positions to fill
        distributeOnes(numOfOnesRemaining - 1, positionsToFill - i - 1, sb, result);
        // undo the changes that we made to sb
        sb.setLength(sbLength);
    }
}