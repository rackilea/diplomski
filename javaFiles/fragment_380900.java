public void createInitialLayout(IPageLayout layout) {
   String editorArea = layout.getEditorArea();
   layout.setFixed(false);
   layout.setEditorAreaVisible(true);

   layout.addStandaloneView("your.domain.and.FormView", true,IPageLayout.RIGHT, 0.15f, editorArea);