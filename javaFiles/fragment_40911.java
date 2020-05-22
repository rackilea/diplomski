class MultipleDirectoriesTreeModel implements TreeModel {
    protected List<File> roots;

    public MultipleDirectoriesTreeModel(File... roots) {
        this.roots = Arrays.asList(roots);
    }

    public Object getRoot() { return this; }

    public boolean isLeaf(Object node) {
        return node instanceof File && ((File)node).isFile();
    }

    public int getChildCount(Object parent) {
        if (parent == this)
            return roots.size();
        else {
            String[] children = ((File) parent).list();
            if (children == null)
                return 0;
            return children.length;
        }
    }

    public Object getChild(Object parent, int index) {
        if (parent == this)
            return index >= 0 && index < roots.size() ? roots.get(index) : null;
        else {
            String[] children = ((File) parent).list();
            if ((children == null) || (index >= children.length))
                return null;
            return new File((File) parent, children[index]);
        }
    }

    public int getIndexOfChild(Object parent, Object child) {
        String childname = ((File) child).getName();
        if (parent == this) {
            for (int rootIndex = 0; rootIndex < roots.size(); rootIndex++)
                if (childname.equals(roots.get(rootIndex).getName()))
                    return rootIndex;
            return -1;
        } else {
            String[] children = ((File) parent).list();
            if (children == null)
                return -1;
            for (int i = 0; i < children.length; i++) {
                if (childname.equals(children[i]))
                    return i;
            }
            return -1;
        }
    }

    @Override
    public String toString() {
        return "My Computer";
    }

    public void valueForPathChanged(TreePath path, Object newvalue) {}
    public void addTreeModelListener(TreeModelListener l) {}
    public void removeTreeModelListener(TreeModelListener l) {}
}