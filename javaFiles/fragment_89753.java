class Main {
    public static void main(String[] args) {
        int n = 415;
        int[] arr = {415};
        doit(n);
        doitPointer(arr);

        System.out.println("Copy primitive: " + n);
        System.out.println("Copy reference to object: " + arr[0]);
    }

    static void doit(int n) {
        n = 42; // assignment to local variable which will be unavailable in outer scope
    }

    static void doitPointer(int[] res) {
        res[0] = 42; // assignment to element in referenced array, available in outer scope
    }
}