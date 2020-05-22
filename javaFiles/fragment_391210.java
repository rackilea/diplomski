public final class CustomDocumentFilter extends DocumentFilter 
{
    private StyledDocument styledDocument;
    private JTextPane pane;

    public CustomDocumentFilter(JTextPane pane) {
        this.pane = pane; // Not really necessary
        this.styledDocument = pane.getStyledDocument();
    } 

    // Override some DocumentFilter methods here like insert and remove
}