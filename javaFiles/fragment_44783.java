public class Weather {

private static final int Uninitialized = -999;

public static void main(String[] args) {

    int[] low = new int[args.length];

    for (int i = 0; i < args.length; i++) {
        System.out.print(args[i] + " ");
        low[i] = Integer.parseInt(args[i]);
    }
    System.out.println("\n");
    int[] lowest = new int[2];
    lowest = FindLowestTempInArray(low);
    System.out.println(lowest[0] + "   " + lowest[1]);

}

public static int[] FindLowestTempInArray(int[] T) {
    int[] lowest = new int[2];
    lowest[0] = Uninitialized;
    lowest[1] = 0;
    for (int day = 0; day < T.length; day++) {
        if (T[day] != Uninitialized
                && (T[day] < lowest[0] || lowest[0] == Uninitialized)) {
            lowest[0] = T[day];
            lowest[1] = day;
        }
    }
    return lowest;
}