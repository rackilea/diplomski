public static void main(String args[]) {
    char[] keys = {'D', 'B', 'D', 'C', 'C', 'D', 'A', 'E', 'A', 'D'};
    int correctCount = 0;
    for (int i = 0; i < args.length && i < keys.length; i++) {
        if (args[i].charAt(0) == keys[i]) {
            correctCount++;
        }
    }
    System.out.println("Your correct count is " + correctCount);
}