public E ceiling(final E target) { 
     return ceilingHelper(root, root.my_element, target);
 }

 private E ceilingHelper(final AANode<E> current_node, 
                         final E SGT, 
                         final E target) { 
    //now do you get the idea ?  your recursion will need a base case
    //and a recursive step.  you can traverse the tree using a depth first
    //search
 }