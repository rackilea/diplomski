public class TreeGridResponse {
    //inject the service to get the id of your model
    @Resource
    CourtBranchService cbService;
    //if you are using a repository for the db queries:
    @Resource
    CourtBranchRepository cbRepo;

    public TreeGridResponse(){
    }

    //returning the tree as a JSON to use AJAX
    public String cbBTreeAsJson(final CourtBranchTree tree){
        final StringBuffer sb = new StringBuffer();
        final CourtBranch root = tree.getRootElement().getData();
        sb.append("[\r {\"title\": \"" + root.getName() + "\", \"key\": \"" + root.getId() + "\", \"children\": [\r");
        final List<Node<CourtBranch>> children = tree.getRootElement().getChildren();
        loopforChildre(sb, children);
        sb.append("]");
        return sb.toString();
    }

    private StringBuffer loopForChildren(final StringBuffer sb, final List<Node<UserRight>> children) {
        for (int i = 0; i < children.size(); i++) {
            final Node<courtBranch> childElement = children.get(i);
            if (i == 0) {
                sb.append("{\"title\": \"" + childElement.getData().getName() + "\", \"key\": \"" + childElement.getData().getId() + "\"");
            } else {
                sb.append(", {\"title\": \"" + childElement.getData().getName() + "\", \"key\": \"" + childElement.getData().getId() + "\"");
            }
            if (childElement.hasChildren()) {
                sb.append(", \"children\": [\r");
                loopForChildren(sb, childElement.getChildren());
            } else {
                sb.append("}");
            }
        }
        sb.append("]}");
        return sb;
    }

    public CourtBranchTree get() {
        final CourtBranchTreetree tree = new CourtBranchTree();
        final Node<CourtBranch> root = new Node<CourtBranch> (this.cbRepo.findOne(Long.valueOf(1)));//gets your root
        getRecursive(root, tree);
        tree.setRootElement(root);
        return tree;
    }

    private void getRecursive(final Node<CourtBranch> courtBranch, final CourtBranchTree tree) {
        final List<CourtBranch> children = this.cbService.findCourtBranchByParentId(courtBranch.getData().getId());
        final List<Node<CourtBranch>> childElements = new ArrayList<Node<CourtBranch>>();
        for (final CourtBranch childCourtBranch : children) {
            final Node<CourtBranch> childElement = new Node<CourtBranch>(childUserRight);
            childElements.add(childElement);
            getRecursive(childElement, tree);
        }
        courtBranch.setChildren(childElements);
    }
}