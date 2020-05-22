public class AdvancedPropertySection extends AbstractPropertySection {

    protected PropertySheetPage page;

    public void createControls(Composite parent,
            final TabbedPropertySheetPage atabbedPropertySheetPage) {
        super.createControls(parent, atabbedPropertySheetPage);
        Composite composite = getWidgetFactory()
            .createFlatFormComposite(parent);
        page = new PropertySheetPage();

        page.createControl(composite);
        FormData data = new FormData();
        data.left = new FormAttachment(0, 0);
        data.right = new FormAttachment(100, 0);
        data.top = new FormAttachment(0, 0);
        data.bottom = new FormAttachment(100, 0);
        page.getControl().setLayoutData(data);

        page.getControl().addControlListener(new ControlAdapter() {

            public void controlResized(ControlEvent e) {
                atabbedPropertySheetPage.resizeScrolledComposite();
            }
        });
    }

    public void setInput(IWorkbenchPart part, ISelection selection) {
        super.setInput(part, selection);
        page.selectionChanged(part, selection);
    }

    public void dispose() {
        super.dispose();

        if (page != null) {
            page.dispose();
            page = null;
        }

    }

    public void refresh() {
        page.refresh();
    }

    public boolean shouldUseExtraSpace() {
        return true;
    }
}