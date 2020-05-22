private static List<List<Integer>> findPaths(Node node){

    if (node == null) 
        return new ArrayList<List<Integer>>();

    List<List<Integer>> paths = new ArrayList<List<Integer>>();

    List<List<Integer>> left_subtree = findPaths(node.left);
    List<List<Integer>> right_subtree = findPaths(node.right);


    for(int i=0;i<left_subtree.size();++i){
        List<Integer> new_path = new ArrayList<Integer>();
        new_path.add(node.key);
        new_path.addAll(left_subtree.get(i));
        paths.add(new_path);
    }

    for(int i=0;i<right_subtree.size();++i){
        List<Integer> new_path = new ArrayList<Integer>();
        new_path.add(node.key);
        new_path.addAll(right_subtree.get(i));
        paths.add(new_path);
    }


    if(paths.size() == 0){
        paths.add(new ArrayList<Integer>());
        paths.get(0).add(node.key);
    }

    return paths;
}