OutputNodeHierachical dataSource = new OutputNodeHierachical(rootNodes);

Tree mainTree = new Tree();
mainTree.setSizeFull();
mainTree.setContainerDataSource(dataSource);
mainTree.addItemClickListener(new ItemClickListener() {
    private static final long serialVersionUID = -413371711541672605L;

    @Override
    public void itemClick(ItemClickEvent event) {
        OutputNode node = (OutputNode) event.getItemId();
        openObject(node.getObjectId());
    }
});