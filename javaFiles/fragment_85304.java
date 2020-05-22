public class PerspectiveExplore implements IPerspectiveFactory {

    public static final String ID = "UF.PerspectiveExplore";
    @Override
    public void createInitialLayout(IPageLayout layout) {
        String editorArea = layout.getEditorArea();
        layout.setEditorAreaVisible(false);

        IFolderLayout workflowSelection = layout.createFolder("Workflow Selection", IPageLayout.LEFT, 0.20f, editorArea);
        workflowSelection.addPlaceholder(WorkflowSelection.ID + ":*");
        workflowSelection.addView(WorkflowSelection.ID);

        IFolderLayout filter = layout.createFolder("Filter", IPageLayout.BOTTOM, 0.5f, WorkflowSelection.ID);
        filter.addPlaceholder(FilterView.ID + ":*");
        filter.addView(FilterView.ID);

        IFolderLayout resultSelection = layout.createFolder("Result Selection", IPageLayout.BOTTOM, 0.5f, editorArea);
        resultSelection.addPlaceholder(ResultSelection.ID + ":*");
        resultSelection.addView(ResultSelection.ID);

        IFolderLayout canvas = layout.createFolder("Plot", IPageLayout.TOP, 0.6f, ResultSelection.ID);
        canvas.addPlaceholder(Plot.ID + ":*");
        canvas.addView(Plot.ID);    
    }

}