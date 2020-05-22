private static class MyJTree extends JTree {
    ...
    public void invalidateNodeBoundsViaSideEffect() {
        if (ui instanceof BasicTreeUI) {
            BasicTreeUI basicTreeUI = (BasicTreeUI) ui;
            basicTreeUI.setLeftChildIndent(basicTreeUI.getLeftChildIndent());
        }}

    public void invalidateNodeBoundsViaRefection() {
        if (ui instanceof BasicTreeUI) {
            try {
                Field field = BasicTreeUI.class.getDeclaredField("treeState");
                field.setAccessible(true);

                AbstractLayoutCache treeState = (AbstractLayoutCache) field.get(ui);

                if (treeState != null) {
                    treeState.invalidateSizes();
                }
            } catch (Exception e) {
            }
        }}}