while(!list.isEmpty()){
    System.out.println("First loop. Current level: "+list);
    int size = list.size();
    List<Integer> temp = new ArrayList<Integer>();
    while(size != 0) {
        root = list.remove();
        System.out.println("Second loop. Current node: "+root);

        if(root.left != null)  list.add(root.left);
        if(root.right != null) list.add(root.right);

        temp.add(root.val);
        size--;
        res.add(temp);
    }
}