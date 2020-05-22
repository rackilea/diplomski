public class TreeToArray extends TreeBaseListener {
    Stack<String> partialPath = new Stack<>();
    public List<String> paths = new ArrayList<>();

    @Override
    public void enterRoot(TreeParser.RootContext ctx) {
        if (partialPath.isEmpty()) {
            // We are in top-root, partial path consists of top-root's name
            partialPath.push(ctx.node().getText());
        } else {
            // We are in one of the sub-roots, partialPath.peek() returns a current partial path
            partialPath.push(partialPath.peek() + " " + ctx.node().getText());
        }
    }

    @Override
    public void enterValue(TreeParser.ValueContext ctx) {
        paths.add(partialPath.peek() + " " + ctx.getText());
    }

    @Override
    public void exitRoot(TreeParser.RootContext ctx) {
        partialPath.pop();
    }
}