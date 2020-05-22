import java.io.File;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.ProgressBar;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Rectangle;
import java.awt.Robot.*;

public class Demo {

    static Spinner s;

    public static void main(final String[] args) {
    final Display display = new Display();
    final Shell shell = new Shell(display);
    FillLayout layout= new FillLayout();
    shell.setLayout(layout);

    Composite comp=new Composite(shell, SWT.BORDER_DOT);
    RowLayout r1=new RowLayout(SWT.HORIZONTAL);
    r1.wrap=true;
    r1.justify=true;
    r1.pack=true;
    r1.marginLeft=0;

    RowLayout r2=new RowLayout(SWT.VERTICAL);
    r2.wrap=true;
    r2.justify=true;
    r2.pack=true;
    r2.marginLeft=0;

    comp.setLayout(r1);
    Group grp1;


    grp1= new Group(comp,SWT.BORDER_DASH);
    grp1.setLayout(r2);
    Label l11,l22;
    Text txt;
    Button btn;

    l11=new Label(grp1, SWT.NONE);
    l11.setText("Label1");
    l22=new Label(grp1, SWT.NONE);
    l22.setText("Label2");
    txt= new Text(grp1, SWT.BORDER);
    btn= new Button(grp1, SWT.PUSH);

    Group grp2;


    Label l1,l2;
    grp2= new Group(comp,SWT.BORDER);
    grp2.setLayout(r2);

    //grp2.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

    l1= new Label(grp2, SWT.NONE);
    l1.setText("lable1");

    l2= new Label(grp2, SWT.NONE);
    l2.setText("lable1");

    final ImgCanvas imgCanvas = new ImgCanvas(grp2);


    //shell.redraw();
//  shell.setSize(600, 600);
    shell.open();
    shell.layout();

    btn.addSelectionListener(new SelectionListener() {

        @Override
        public void widgetSelected(SelectionEvent e)
        {
            //get a screenshot of a particular screen region using Java.Awt.Robot.captureScreenRegion,
            //convert the image into a SWT image, and try to show it:
            Image screenshot = new Image(display, "c:\\temp\\imgmsg.png"); 
            imgCanvas.setImage(screenshot);
            System.out.println("redrawn");

        }

        @Override
        public void widgetDefaultSelected(SelectionEvent arg0) {
            // TODO Auto-generated method stub

        }
    });
    while (!shell.isDisposed()) {
      if (!display.readAndDispatch()) {
        display.sleep();
      }
    }  }}