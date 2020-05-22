public static class AnOrder extends Traverse {
        public void run(Node node) {
            run(node.left);
            run(node.right);
            print(node);
        }
    }