import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BreadthFirstSearch {

    public static void main(String[] args) {
        //just for testing
        new BreadthFirstSearch();
    }

    public BreadthFirstSearch() {
        //build a TreeNode<T> graph for testing
        TreeNode<Integer> root = new TreeNode<Integer>(1);

        TreeNode<Integer> child_1 = new TreeNode<Integer>(2);
        TreeNode<Integer> child_2 = new TreeNode<Integer>(3);
        TreeNode<Integer> child_1_1 = new TreeNode<Integer>(4);
        TreeNode<Integer> child_1_2 = new TreeNode<Integer>(5);
        TreeNode<Integer> child_2_1 = new TreeNode<Integer>(6);
        TreeNode<Integer> child_2_2 = new TreeNode<Integer>(7);
        TreeNode<Integer> child_1_2_1 = new TreeNode<Integer>(8);
        TreeNode<Integer> child_2_2_1 = new TreeNode<Integer>(9);

        child_1.setChildren(Arrays.asList(child_1_1, child_1_2));
        child_2.setChildren(Arrays.asList(child_2_1, child_2_2));
        child_1_2.setChildren(Arrays.asList(child_1_2_1));
        child_2_2.setChildren(Arrays.asList(child_2_2_1));
        root.setChildren(Arrays.asList(child_1, child_2));

        //now root is a graph like this:

        //              1
        //           /     \
        //          2       3
        //         /  \    /  \
        //        4   5   6    7
        //           /        /
        //          8        9

        //so the breadth first search should lead to the result list: [1, 2, 3, 4, 5, 6, 7, 8, 9]
        List<Integer> breadthFirstSearched = BFS(root);
        System.out.println(breadthFirstSearched);
    }

    /**
     * A simple TreeNode<T> implementation.
     */
    public class TreeNode<T> {

        private List<TreeNode<T>> children;
        private T value;

        public TreeNode(T value) {
            children = new ArrayList<TreeNode<T>>();
            this.value = value;
        }

        public List<TreeNode<T>> getChildren() {
            return children;
        }
        public void setChildren(List<TreeNode<T>> children) {
            this.children = children;
        }

        public T getValue() {
            return value;
        }
        public void setValue(T value) {
            this.value = value;
        }
    }

    public static <T> List<T> BFS(TreeNode<T> root) {//here you just need the root node which also holds the graph in this implementation
        List<T> S = new ArrayList<T>();//here you should use the generic type T (if the TreeNode<T> is a TreeNode<Integer> it will be a List<Integer> on runtime)
        Queue<TreeNode<T>> Q = new LinkedList<TreeNode<T>>();//here you need a queue of TreeNode<T> objects instead of integers

        S.add(root.getValue());
        Q.add(root);

        //this would just remove all elements from the queue before starting the real algorithm
        /*while (!Q.isEmpty()) {
            Q.remove();
        }*/

        //in the pseudocode you provided the code after the while was indented, which means it belongs inside the while loop like this:
        while (!Q.isEmpty()) {
            //here you need to get the first TreeNode<T> from the queue
            TreeNode<T> current = Q.poll();//poll is equal to dequeue here (both get the first element of the queue and remove it from the queue)
            for (TreeNode<T> n : current.getChildren()) {//iterate over all children of the current node
                if (!S.contains(n.getValue())) {//here you need to check the value of n (otherwise you compare TreeNode<T> to T which doesn't make much sense)
                    S.add(n.getValue());
                    Q.add(n);
                }
            }
        }

        //here you should return the created list, otherwise it's no longer available
        return S;
    }
}