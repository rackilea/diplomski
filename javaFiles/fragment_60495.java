public static void printsparsetablehelp(int start, int end, int initialStart) {
    if(start == initialStart || fibby(start) != fibby(start - 1)) {
        System.out.println(start + " " + fibby(start));
    }
    if(start + 1 <= end) {
        printsparsetablehelp(start + 1, end, initialStart);
    }
}