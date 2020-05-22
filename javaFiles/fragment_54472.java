/**
 * This will add a page to the document.  This is a convenience method, that
 * will add the page to the root of the hierarchy and set the parent of the
 * page to the root.
 *
 * @param page The page to add to the document.
 */
public void addPage( PDPage page )
{
    PDPageNode rootPages = getDocumentCatalog().getPages();
    rootPages.getKids().add( page );
    page.setParent( rootPages );
    rootPages.updateCount();
}