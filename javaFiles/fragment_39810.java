package test;


import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

public class GUIThread implements Runnable 
{
    private Display display;
    private Label label;
    public Display getDisplay(){
        return display;
    }
    public void run() 
    {
        display = new Display();
        Shell shell = new Shell(display);
        shell.setLayout(new GridLayout());
        shell.setLayoutData(new GridData(SWT.FILL,SWT.FILL,true,false));
        label = new Label(shell,SWT.NONE);
        label.setText(" -- ");
        shell.open();
        shell.pack();

        while (!shell.isDisposed()) {
        if (!display.readAndDispatch ()) display.sleep ();
        }
        display.dispose();
    }

    public synchronized void update(final int value)
    {
        if (display == null || display.isDisposed()) 
            return;
        display.asyncExec(new Runnable() {

            public void run() {
                label.setText(""+value);
            }
        });

    }

}