public class Test {
    public static void main(String[] args) throws Exception {
        NaryTree tree = new NaryTree(100,
            new NaryTree(90, 
                new NaryTree(20),
                new NaryTree(30)
            ), new NaryTree(50, 
                new NaryTree(200),
                new NaryTree(300)
            ), new NaryTree(70)
        );
        for (int x : tree.inOrderView) {
            System.out.println(x);
        }
    }
}