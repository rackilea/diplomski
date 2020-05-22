/* Returns true if binary tree with root as root is height-balanced */
        boolean isBalanced(Node root) {
            if(root == null) return false;

            Deque<Integer> heights = new LinkedList<>();
            Deque<Node> trail = new LinkedList<>();
            trail.push(root);

            Node prev = root; //set to root not null to not confuse when root is misisng children

            while(!trail.isEmpty()) {
                Node curr = trail.peek(); //get the next node to process, peek because we need to maintain trail until we return

                //if we just returned from left child
                if (curr.left == prev) {
                    if(curr.right != null) trail.push(curr.right); //if we can go right go
                    else {
                        heights.push(-1); //otherwise right height is -1 does not exist and combine heights
                        if(!combineHeights(heights)) return false;
                        trail.pop(); //back to parent
                    }
                }
                //if we just returned from right child
                else if (curr.right == prev) {
                    if(!combineHeights(heights)) return false;
                    trail.pop(); //up to parent
                }
                //this came from a parent, first thing is to visit the left child, or right if no left
                else {
                    if(curr.left != null) trail.push(curr.left);
                    else {
                        if (curr.right != null) {
                            heights.push(-1); //no left so when we combine this node left is 0
                            trail.push(curr.right); //since we never go left above logic does not go right, so we must here
                        }
                        else { //no children set height to 1
                            heights.push(0);
                            trail.pop(); //back to parent
                        }
                    }
                }

                prev = curr;
            }

            return true;
        }

        //pop both previous heights and make sure they are balanced, if not return false, if so return true and push the greater plus 1
        private boolean combineHeights(Deque<Integer> heights) {
            int rightHeight = heights.pop();
            int leftHeight = heights.pop();

            if(Math.abs(leftHeight - rightHeight) > 1) return false;
            else heights.push(Math.max(leftHeight, rightHeight) + 1);
            return true;
        }