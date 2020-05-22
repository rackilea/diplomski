public class PermutationsNoAdjacent {

    private char[] inputChars;
    private boolean[] inputUsed;
    private char[] outputChars;
    private List<String> permutations = new ArrayList<>();

    public PermutationsNoAdjacent(String inputString) {
        inputChars = inputString.toCharArray();
        inputUsed = new boolean[inputString.length()];
        outputChars = new char[inputString.length()];
    }

    private String[] generatePermutations() {
        tryFirst();
        return permutations.toArray(new String[permutations.size()]);
    }

    private void tryFirst() {
        for (int inputIndex = 0; inputIndex < inputChars.length; inputIndex++) {
            assert !inputUsed[inputIndex] : inputIndex;
            outputChars[0] = inputChars[inputIndex];
            inputUsed[inputIndex] = true;
            tryNext(inputIndex, 1);
            inputUsed[inputIndex] = false;
        }
    }

    private void tryNext(int previousInputIndex, int outputIndex) {
        if (outputIndex == outputChars.length) { // done
            permutations.add(new String(outputChars));
        } else {
            // avoid previousInputIndex and adjecent indices
            for (int inputIndex = 0; inputIndex < previousInputIndex - 1; inputIndex++) {
                if (!inputUsed[inputIndex]) {
                    outputChars[outputIndex] = inputChars[inputIndex];
                    inputUsed[inputIndex] = true;
                    tryNext(inputIndex, outputIndex + 1);
                    inputUsed[inputIndex] = false;
                }
            }
            for (int inputIndex = previousInputIndex + 2; inputIndex < inputChars.length; inputIndex++) {
                if (!inputUsed[inputIndex]) {
                    outputChars[outputIndex] = inputChars[inputIndex];
                    inputUsed[inputIndex] = true;
                    tryNext(inputIndex, outputIndex + 1);
                    inputUsed[inputIndex] = false;
                }
            }
        }
    }

    public static void main(String... args) {
        String[] permutations = new PermutationsNoAdjacent("ABCDEF").generatePermutations();
        for (String permutation : permutations) {
            System.out.println(permutation);
        }
    }

}