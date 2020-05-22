public abstract static class Traverse {
        public abstract void run(Node node);

        protected void print(Node node) {
            System.out.println(" " + node.data);
        }
    }