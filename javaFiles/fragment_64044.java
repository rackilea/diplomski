List<Object> path = new ArrayList<>();

path.add(root element);

... path.add(intermediate elements in tree);

path.add(node element);  

TreePath treePath = new TreePath(path.toArray());

viewer.expandToLevel(treePath, 1);