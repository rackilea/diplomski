// Dequeue all nodes of current level and Enqueue all
        // nodes of next level
        while (nodeCount > 0) {

            //make a copy of the node at the top of the queue 
            Node newnode = q.peek(); 

            //remove the node to be checked from the queue so it will not be checked again
            q.remove();

            //since node was removed, update the number of nodes to be checked
            nodeCount--;

            //check top node is connected to other nodes 
            if (newnode.left != null) {
                q.add(newnode.left); //add left node to queue to be checked
            }
            if (newnode.right != null) {
                q.add(newnode.right);  //add right node to queue to be checked
            }
        }