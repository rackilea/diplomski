public class Tree234<T extends Comparable<? super T>>{  
    private class Node{  
        T[] data=(T[]) new Comparable[3];  // need to be a comparable, as the superclass is known.
        Node[] next = (Node[]) new Tree234.Node[4];  

    }  
}