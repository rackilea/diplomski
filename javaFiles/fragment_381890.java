public class TreePathsTest {
    TreeNode[] nodes = new TreeNode[10];

    @Before
    public void init() {
        int count = 0;
        for(TreeNode child : nodes) {
            nodes[count] = new TreeNode(String.valueOf(count));
            count++;
        }
    }

    /*
     * 0 - 1 - 3
     *       - 4
     *   - 2 - 5
     *       - 6
     *       - 7 - 8
     *           - 9
     */
    private void constructBasicTree() {
        nodes[0].addChild(nodes[1]);
        nodes[0].addChild(nodes[2]);
        nodes[1].addChild(nodes[3]);
        nodes[1].addChild(nodes[4]);
        nodes[2].addChild(nodes[5]);
        nodes[2].addChild(nodes[6]);
        nodes[2].addChild(nodes[7]);
        nodes[7].addChild(nodes[8]);
        nodes[7].addChild(nodes[9]);
    }

    @Test
    public void testPaths() {
        constructBasicTree();
        List<List<TreeNode>> lists = TreePaths.getPaths(nodes[0]);
        for(List<TreeNode> list : lists) {
            for(int count = 0; count < list.size(); count++) {
                System.out.print(list.get(count).getId());
                if(count != list.size() - 1) {
                    System.out.print("-");
                }
            }
            System.out.println();
        }
    }
}