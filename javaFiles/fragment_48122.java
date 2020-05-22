public static void main(String[] args) {
    int[] first = new int[]{1, 3, 3, 3, 4};
    replaceMaxWithMin(first);
    System.out.println("******************************************");
    int[] second = new int[]{5, 4, 2, 2, 4, 2, 2, 5};
    replaceMaxWithMin(second);
    System.out.println("******************************************");
    int[] fromScanner = readFromScanner();
    System.out.println("From scanner: " + Arrays.toString(fromScanner));
    replaceMaxWithMin(fromScanner);
}

private static void replaceMaxWithMin(int[] marks) {
    int max = Integer.MIN_VALUE;
    int min = Integer.MAX_VALUE;
    for (int mark : marks) {
        min = Math.min(min, mark);
        max = Math.max(max, mark);
    }
    for (int i = 0; i < marks.length; i++) {
        if (marks[i] == max) {
            marks[i] = min;
        }
    }
    for (int i = 0; i < marks.length; i++) {
        if (i != marks.length - 1) {
            System.out.print(marks[i] + " ");
        } else {
            System.out.println(marks[i]);
            System.out.println();
        }
    }
}

private static int[] readFromScanner() {
    Scanner sc = new Scanner(System.in);
    int[] marks = new int[sc.nextInt()];
    for(int i=0;i<marks.length;i++){
        marks[i] = sc.nextInt();
    }
    return marks;
}