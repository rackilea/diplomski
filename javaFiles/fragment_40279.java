public static void print(double[] arr) {
    StringBuilder sb = new StringBuilder();
    for (double x : arr) {
        sb.append(x);
        sb.append(", ");
    }
    System.out.println(sb.toString());
}

public static void main(String[] args) {
    double[][] mx1 = { { 1, 2 }, { 4, 8 } };
    int[] vec1 = { 0, 1 };
    int[] vec2 = { 1, 0 };
    int[] vec3 = { 5, 7 };

    print(cryptMsg(mx1, vec1)); // 2.0, 8.0,
    print(cryptMsg(mx1, vec2)); // 1.0, 4.0,
    print(cryptMsg(mx1, vec3)); // 19.0, 76.0,

    int[] vec4 = { 104, 105 };
    double[][] mx2 = { { 85, 15 }, { 79, 21 } };
    print(cryptMsg(mx2, vec4)); // 10415.0, 10421.0,
}