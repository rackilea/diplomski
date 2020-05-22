protected TreeSelectionListener createReflectiveSelectionListener() {
    TreeSelectionListener l = new TreeSelectionListener() {

        @Override
        public void valueChanged(TreeSelectionEvent e) {
            invalidateLayoutCache();
        }

        protected void invalidateLayoutCache() {
            BasicTreeUI ui = (BasicTreeUI) tree.getUI();
            try {
                Method method = BasicTreeUI.class.getDeclaredMethod("configureLayoutCache");
                method.setAccessible(true);
                method.invoke(ui);
            } catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e1) {
               e1.printStackTrace();
            }
        }
    };
    return l;
}