import org.eclipse.swt.*;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.*;

public class TableScrollVisibilityTest 
{
    private static int count;

    public static void main(String [] args) 
    {
        Display display = new Display();
        Shell shell = new Shell(display);
        shell.setBounds(10,10,300,300);
        shell.setLayout(new GridLayout(2,true));

        final Table table = new Table(shell, SWT.NONE);
        GridData data = new GridData(GridData.FILL_BOTH);
        data.horizontalSpan = 2;
        table.setLayoutData(data);

        count = 0;

        final Button addItem = new Button (shell, SWT.PUSH);
        addItem.setText ("Add Row");
        data = new GridData(SWT.FILL, SWT.FILL, true, false);
        data.horizontalSpan = 2;
        addItem.setLayoutData(data);

        final Text text = new Text(shell, SWT.BORDER);
        text.setText ("Vertical Scroll Visible - ");
        data = new GridData(SWT.FILL, SWT.FILL, true, false);
        data.horizontalSpan = 2;
        text.setLayoutData(data);


        addItem.addListener (SWT.Selection, new Listener () 
        {
            public void handleEvent (Event e) 
            {
                new TableItem(table, SWT.NONE).setText("item " + count);
                count++;
            }
        });


        table.addPaintListener(new PaintListener() {
            public void paintControl(PaintEvent e) {
                Rectangle rect = table.getClientArea ();
                int itemHeight = table.getItemHeight ();
                int headerHeight = table.getHeaderHeight ();
                int visibleCount = (rect.height - headerHeight + itemHeight - 1) / itemHeight;
                text.setText ("Vertical Scroll Visible - [" + (table.getItemCount()>= visibleCount)+"]");

                      // YOUR CODE HERE
            }
        });


        shell.open();
        while (!shell.isDisposed()) {
            if (!display.readAndDispatch()) display.sleep();
        }

        display.dispose();
    }

}