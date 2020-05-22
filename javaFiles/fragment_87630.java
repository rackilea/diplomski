import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;

public class SourceList {

    public static void main(String[] args) {
        Display display = new Display();
        Shell shell = new Shell(display);
        shell.setLayout(new FillLayout());

        final Tree tree = new Tree (shell, SWT.SOURCE_LIST);

        for (int i=0; i<4; i++) {
            final TreeItem iItem = new TreeItem (tree, SWT.GROUP_ITEM);
            display.asyncExec( new Runnable() {
                public void run() {
                    iItem.setExpanded(true);
                }
            });
            iItem.setText ("GROUP " + i);
            for (int j = 0; j < 4; j++) {
                TreeItem jItem = new TreeItem (iItem, 0);
                jItem.setText ("TreeItem " + j);
            }
        }

        shell.open();
        while (!shell.isDisposed()) {
            if (!display.readAndDispatch())
                display.sleep();
        }
        display.dispose();
    }

}