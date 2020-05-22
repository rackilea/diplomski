public static String[] swap(int first, int second, String[] A) {
        String hold = A[first];
        A[first] = A[second];
        A[second] = hold;
        return A;

    }

    public static void main(String[] args) {
        String[] B = { "Dawn", "Justice", "Of" };
        String[] c = swap(1, 2, B);
        System.out.print(Arrays.toString(c));

    }