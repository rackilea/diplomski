import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class TestCase {

private static List<String> model = new ArrayList<String>();
private static TableViewer viewer;

public static void main(String[] args) {
    final Display display = new Display();
    final Shell shell = new Shell(display);
    shell.setLayout(new FillLayout());

//  viewer = new TableViewer(shell, SWT.SINGLE | SWT.FULL_SELECTION |    SWT.H_SCROLL | SWT.V_SCROLL | SWT.VIRTUAL);
    viewer = new TableViewer(shell, SWT.SINGLE | SWT.H_SCROLL | SWT.V_SCROLL | SWT.VIRTUAL);

    viewer.getTable().setHeaderVisible(true);
    viewer.getTable().setLinesVisible(true);
    viewer.setUseHashlookup(true);

    viewer.setContentProvider(ArrayContentProvider.getInstance());
    viewer.setLabelProvider(new LabelProvider());

    model.add("element2");
    model.add("element1");
    model.add("element0");

    viewer.setInput(model);

    viewer.setSelection(new StructuredSelection(model.get(1)));

    viewer.addSelectionChangedListener(new ISelectionChangedListener() {

        @Override
        public void selectionChanged(SelectionChangedEvent event) {
            System.out.println("selection changed");
        }
    });

    addContent();

    shell.setSize(400, 400);
    shell.open();

    while (!shell.isDisposed()) {
        if (!display.readAndDispatch()) {
            display.sleep();
        }
    }
}

private static void addContent() {
    Display.getCurrent().timerExec(2000, new Runnable() {

        @Override
        public void run() {
            model.add(0, "element" + model.size());
            viewer.refresh();
            addContent();
        }
    });
}

}