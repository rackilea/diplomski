package de.abas.erp.wb.base.tools.identifiersearchview;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.graphics.TextLayout;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;

public class TabSnippet {

public static void main(final String [] args) {
    final Display display = new Display();
    final Shell shell = new Shell(display);
        shell.setText("Table:\t\t Change style \t multiple times in cell");
    shell.setLayout(new FillLayout());
    final Table table = new Table(shell, SWT.MULTI | SWT.FULL_SELECTION);
    table.setLinesVisible(true);
    for(int i = 0; i < 10; i++) {
        new TableItem(table, SWT.NONE);
    }
    final TextLayout textLayout = new TextLayout(display);
        textLayout.setText("SWT:\t Standard \t Widget \t Toolkit");
        textLayout.setTabs(new int[] { 100 });

        /*
         * NOTE: MeasureItem, PaintItem and EraseItem are called repeatedly.
         * Therefore, it is critical for performance that these methods be as
         * efficient as possible.
         */
        table.addListener(SWT.PaintItem, new Listener() {
            @Override
            public void handleEvent(final Event event) {
                textLayout.draw(event.gc, event.x, event.y);
            }
        });
        final Rectangle textLayoutBounds = textLayout.getBounds();
        table.addListener(SWT.MeasureItem, new Listener() {
            @Override
            public void handleEvent(final Event e) {
                e.width = textLayoutBounds.width + 2;
                e.height = textLayoutBounds.height + 2;
            }
        });
    shell.setSize(400, 200);
    shell.open();
    while(!shell.isDisposed()) {
        if(!display.readAndDispatch()) {
            display.sleep();
        }
    }
    textLayout.dispose();
    display.dispose();
}
}