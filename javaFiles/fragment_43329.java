public static int[] difference(String input, String[] binary_patterns_array){
    int[] difference_array = new int[32];
    String  binary_pattern = "";
    for(int i = 0; i < binary_patterns_array.length; i++){
        int count = 0; // moved inside the loop so it is 0 at the beginning of each pattern
        binary_pattern = binary_patterns_array[i];
        for(int j = 0; j < input.length(); j++){
            if (binary_pattern.charAt(j) != input.charAt(j)){
                count += 1;
            }
        }
        difference_array[i] = count; // moved because it is cleaner outside the inner loop
    }
    return difference_array;
}