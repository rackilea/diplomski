public static void main(String[] args) {

    // Create your list of numbers
    List<Integer> list = new ArrayList<Integer>();
    list.add(0);
    list.add(1);
    list.add(2);

    getPermutations(list, 7, "");
}

/**
 * Prints all possible permutations with a given list of numbers and a given
 * length of the output strings.
 * 
 * @param list
 *            - The list of possible numbers
 * @param depth
 *            - The recursion depth which equals the lengths of the output
 *            strings
 * @param val
 *            - The current value of the output string
 */
public static void getPermutations(List<Integer> list, int depth, String val) {
    if (depth <= 0) {
        return;
    }
    if (depth == 1) {
        for (Integer number : list) {
            System.out.println(number + val);
        }
    } else {
        for (Integer number : list) {
            getPermutations(list, depth - 1, number + val);
        }
    }
}