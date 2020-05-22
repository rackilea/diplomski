if(node.left != null)
        {


        insert(node.left, value);   
        System.out.println("Parent node of node"+ node.left.value+"is:"+prevnode.value);
        }