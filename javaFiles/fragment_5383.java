public class Test {
    public static void main(String[] args) {
        int number = 2;
        Integer myInteger = number;
        Node<Integer> myNode = new Node<Integer>(number, number);
        System.out.println(myNode.getValue());
    }

    public static class Node<T> {
        private int key;
        private T value;

        public Node(int key, T value) {
            this.key = key;
            this.value = value;
        }

        public T getValue() {
            return value;
        }
    }    
}