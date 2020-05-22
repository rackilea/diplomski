package example;

public class FlattenAList {

    private static MultiNode<Integer> merge(MultiNode<Integer> a, MultiNode<Integer> b) {
        MultiNode<Integer> head = new MultiNode<Integer>();
        MultiNode<Integer> temp = head;
        while (a != null && b != null) {
            if (a.data < b.data) {
                temp.down = a;
                temp = temp.down;
                a = a.down;
            } else if (b.data < a.data) {
                temp.down = b;
                temp = temp.down;
                b = b.down;
            }
        }

        temp.down = (a == null) ? b : a;
        return head.down;
    }

    static class MultiNode<T> {
        T data;
        MultiNode<T> right;
        MultiNode<T> down;

        public MultiNode(T data) {
            this.data = data;
        }

        public MultiNode() {

        }
    }

    public static MultiNode<Integer> flatten(MultiNode<Integer> root) {

        MultiNode<Integer> temp = root;
        MultiNode<Integer> result = null;
        while (temp != null) {
            result = merge(temp, result);
            temp = temp.right;
        }
        return result;
    }

    public static void print(MultiNode<Integer> start) {
        while (start != null) {
            System.out.print(start.data+" ");
            start = start.down;
        }
    }

    public static void main(String[] args) {
        MultiNode<Integer> start = new MultiNode<Integer>(5);
        start.right = new MultiNode<Integer>(10);
        start.right.right = new MultiNode<Integer>(19);
        start.right.right.right = new MultiNode<Integer>(28);

        start.down = new MultiNode<Integer>(7);
        start.down.down = new MultiNode<Integer>(8);
        start.down.down.down = new MultiNode<Integer>(30);

        start.right.down = new MultiNode<Integer>(20);

        start.right.right.down = new MultiNode<Integer>(22);
        start.right.right.down.down = new MultiNode<Integer>(50);

        start.right.right.right.down = new MultiNode<Integer>(35);
        start.right.right.right.down.down = new MultiNode<Integer>(40);
        start.right.right.right.down.down.down = new MultiNode<Integer>(45);
        // Node result = flatten(start);
        MultiNode<Integer> result = flatten(start);
        print(result);
    }
}