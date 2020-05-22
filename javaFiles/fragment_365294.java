private TreeView<String> buildTree(MenuContext mC) {
 List<TreeItems> roots = buildParents(mC);
 EnumMap<TreeItems, TreeItem<String>> values = buildTreeValues(mC);
 TreeView<String> tree = new TreeView<>();
 TreeItem<String> root = null;
 int rootsSize = roots.size();
 // Build node w or w/o children in reverse order
 for (int i = rootsSize - 1; i > 0; --i) {
  EnumMap<TreeItems, TreeItem<String>> nodeChildren = getNodeChildren(roots.get(i),values);
  for (Entry<TreeItems, TreeItem<String>> entry : nodeChildren.entrySet()) {
   values.get(roots.get(i)).getChildren().add(entry.getValue());
   values.remove(entry.getKey());
  }
 }
 // Populate tree model
 for (Entry<TreeItems, TreeItem<String>> entry : values.entrySet()) {
  if (entry.getKey().getParent() == null) {
   root = entry.getValue();
  } else {
   if (root == null) {
    root = entry.getValue();
   } else {
    root.getChildren().add(entry.getValue());
   }
  }
 }
 tree.setRoot(root);
 tree.setShowRoot(false);
 return tree;
}

private EnumMap<TreeItems, TreeItem<String>> buildTreeValues(MenuContext mC) {
 EnumMap<TreeItems, TreeItem<String>> treeValues = new EnumMap<>(TreeItems.class);
 for (TreeItems tI : TreeItems.values()) {
  if (tI.getMenuContext().equals(mC)) {
   treeValues.put(tI, new TreeItem<>(tI.getLabel()));
  }
 }
 return treeValues;
}

private List<TreeItems> buildParents(MenuContext mC) {
 List<TreeItems> parents = new ArrayList<>();
 for (TreeItems tI : TreeItems.values()) {
  if (tI.getMenuContext().equals(mC) && !parents.contains(tI.getParent())) {
   parents.add(tI.getParent());
  }
 }
 return parents;
}

private EnumMap<TreeItems, TreeItem<String>> getNodeChildren(TreeItems root,
 EnumMap<TreeItems, TreeItem<String>> values) {
 EnumMap<TreeItems, TreeItem<String>> cNodes = new EnumMap<>(TreeItems.class);
 for (Entry<TreeItems, TreeItem<String>> entry : values.entrySet()) {
  TreeItems parentKey = entry.getKey().getParent();
  if (parentKey != null && root.equals(parentKey)) {
   cNodes.put(entry.getKey(), entry.getValue());
  }
 }
 return cNodes;
}