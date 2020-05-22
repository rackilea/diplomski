/** Forces table never to take more space than parent has*/
public class TableColumnLayout extends org.eclipse.jface.layout.TableColumnLayout {

    @Override
    protected Point computeSize(Composite composite, int wHint, int hHint, boolean flushCache) {
        return new Point(wHint, hHint);
    }
}