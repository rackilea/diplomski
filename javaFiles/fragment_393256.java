/**
 * @param args
 */
public static void main(final String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    sc.nextLine();
    String[] strArr = new String[N];
    // StringBuffer sb = new StringBuffer();
    for (int i = 0; i < N; i++) {
        strArr[i] = sc.nextLine();
    }
    System.out.println(fun(strArr));
}

public static int fun(final String[] arr) {
    TreeSet<String> set = new TreeSet<>();
    for (int i = 0; i < arr.length; i++) {
        char[] chars = arr[i].toCharArray();
        Arrays.sort(chars);
        set.add(new String(chars));
    }
    return set.size();
}