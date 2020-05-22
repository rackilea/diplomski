private static final Pattern nan =
        Pattern.compile("nan", Pattern.CASE_INSENSITIVE);
public static boolean hasNextDouble(Scanner scanner) {
    if(scanner == null)
        return false;
    return scanner.hasNext(nan) || scanner.hasNextDouble();
}
public static double nextDouble(Scanner scanner) {
    if(scanner.hasNext(nan)) {
        scanner.next();
        return Double.NaN;
    }
    return scanner.nextDouble();
}