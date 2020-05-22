class Test1 {
    static int x = 2;

    static {
        x = 3;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(x);
    }
}