public static void main(String[] args) {

    String[][] input = new String[][] { { "AA", "AB", "AC", "AD" },
               { "1", "0", "2", "0" },
               { "2", "1", "3", "3" }, 
               { "3", "3", "0", "2" }, 
               { "0", "2", "1", "1" } };
    String[][] output = new String[input.length][];
    for (int i = 0; i < output.length; i++)
        output[i] = concat(input[i]);
    print(output);

}

private static String[] concat(String[] strings) {
    int n = strings.length;
    String[] result = new String[(n * (n - 1)) / 2];
    int m = 0;
    for (int i = 0; i < n; i++)
        for (int j = i + 1; j < n; j++)
            if (i != j)
                result[m++] = strings[i] + strings[j];
    return result;
}

private static void print(String[][] strings) {
    for (int i = 0; i < strings.length; i++)
        System.out.println(Arrays.asList(strings[i]));
}