package test;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.*;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.events.*;

public class Foo {
    Shell shell;
    Button button1, button2;
    MyComposite composite;

    public Foo() {
        Display display = new Display();
        shell = new Shell(display);
        shell.setLayout(new GridLayout(1, false));

        button1 = new Button(shell, SWT.RADIO);
        button1.setText("Button 1");
        button1.setSelection(true);
        button1.addSelectionListener(new  ButtonListener());

        button2 = new Button(shell, SWT.RADIO);
        button2.setText("Button 2");

        composite = new MyComposite();
        composite.createTexts();

        shell.open();
        shell.pack();

        while(!shell.isDisposed())
            if(!display.readAndDispatch())
                display.sleep();
    }

    /**
     * A custom composite for displaying either two Combos or two Texts
     */
    class MyComposite extends Composite {
        /** Combos */
        Combo combo1, combo2;

        /** Texts */
        Text text1, text2;

        MyComposite() {
            super(shell, SWT.NONE);
            setLayout(new GridLayout(2, true));
        }

        /** create the combos */
        void createCombos() {
            combo1 = new Combo(this, SWT.DROP_DOWN);
            combo1.setText("foo");
            combo2 = new Combo(this, SWT.DROP_DOWN);
            combo2.setText("bar");
        }

        /** create the texts */
        void createTexts() {
            text1 = new Text(this, SWT.SINGLE | SWT.BORDER);
            text1.setText("foo");
            text2 = new Text(this, SWT.SINGLE | SWT.BORDER);
            text2.setText("bar");
        }

        /** dispose all children */
        void disposeAll() {
            for(Widget w : getChildren()) {
                w.dispose();
            }
        }
    }

    class ButtonListener extends SelectionAdapter {
        @Override
        public void widgetSelected(SelectionEvent e) {
            // erase all
            composite.disposeAll();

            // re-add widgets according to radio button state
            if(button1.getSelection()) {
                composite.createTexts();
            }
            else {
                composite.createCombos();
            }

            // re-do layout and fit the shell
            shell.layout();
            shell.pack();
        }
    }

    public static void main(String[] args) {
        new Foo();
    }
}