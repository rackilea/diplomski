private static void validate(String str) {
    for (char c : str.toCharArray()) {
        if ("{}()[]".indexOf(c) < 0){
            throw new IllegalArgumentException("The string contains forbidden characters");
        }
    }
}