public class TreeNode {
    private String id;
    private TreeNode parent;
    private List<TreeNode> children;

    public TreeNode(String id) {
        this.id = id;
        this.children = new LinkedList<>();
    }

    public void addChild(TreeNode child) {
        this.children.add(child);
        child.setParent(this);
    }

    public List<TreeNode> getChildren() {
        return Collections.unmodifiableList(this.children);
    }

    private void setParent(TreeNode parent) {
        this.parent = parent;
    }

    public TreeNode getParent() {
        return this.parent;
    }

    public String getId() {
        return this.id;
    }
}

public class TreePaths {
    private static List<List<TreeNode>> getPaths0(TreeNode pos) {
        List<List<TreeNode>> retLists = new ArrayList<>();

        if(pos.getChildren().size() == 0) {
            List<TreeNode> leafList = new LinkedList<>();
            leafList.add(pos);
            retLists.add(leafList);
        } else {
            for (TreeNode node : pos.getChildren()) {
                List<List<TreeNode>> nodeLists = getPaths0(node);
                for (List<TreeNode> nodeList : nodeLists) {
                    nodeList.add(0, pos);
                    retLists.add(nodeList);
                }
            }
        }

        return retLists;
    }

    public static List<List<TreeNode>> getPaths(TreeNode head) {
        if(head == null) {
            return new ArrayList<>();
        } else {
            return getPaths0(head);
        }
    }
}