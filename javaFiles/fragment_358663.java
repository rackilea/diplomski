public class ArrayPattern {
    static int numbers[] = {1,10,20,3,30};
    static int pattern[] = {0,0,2,2};

    public static void main(String[] args) {
        System.out.println(isPattern(0, 0));
    }

    /**
     * Recursive method that checks for the pattern. If it fails to match pattern starting from index i, it 
     * tries starting from index i+1
     * */
    public static boolean isPattern(int index, int consec){

        // If all pattern values where matched consecutively
        if(consec == pattern.length)
            return true;

        // If the numbers ended and the pattern wasn't found
        if(index == numbers.length)
            return false;

        // If the current number matches the pattern, check the next number at index + 1
        if(checkPattern(pattern[consec], numbers[index])){
            System.out.println(pattern[consec] +" => "+ numbers[index]);
            return isPattern(index+1, consec+1);
        }

        // If the pattern was not found, starting from a specific index. Start from the next index to check if the pattern can be found
        System.out.println(String.format("\nFailed to match pattern, try starting from index: %d\n", (index - consec + 1)));
        return isPattern(index - consec + 1, 0);
    }

     /**
 * Just chesk the pattern:
 * 0 => 1 or 2 digits. 
 * 1 => 1 digit. 
 * 2 => 2 digits 
 */
    public static boolean checkPattern(int pattern, int value){
        String sValue = String.format("%d", value);
        switch (pattern) {
            case 0:
                return sValue.length() <= 2;
            default:
                return sValue.length() == pattern;
        }
    }
}