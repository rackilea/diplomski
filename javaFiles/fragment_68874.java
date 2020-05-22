class RootNode extends FilterNode {
    @Override
    public Action[] getActions(boolean arg0) {
        List<Action> nodeActions = new ArrayList<Action>();
        nodeActions.addAll(Utilities.actionsForPath("Actions/MyCategoryInLayer"));
        return nodeActions.toArray(new Action[nodeActions.size()]);
    }
}