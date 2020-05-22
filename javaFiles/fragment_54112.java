public class Midlet extends MIDlet implements ActionListener{

Form f;
Container c;
private int ROWS=100;
Button b[][];
private int COLUMNS=3;
public void startApp() {
    Display.init(this);

    f=new Form("grid with buttons");
    c=new Container(new TableLayout(ROWS, COLUMNS));
    b=new Button[ROWS][COLUMNS];
    c.setScrollableX(true);
    c.setScrollableY(true);
    //c.setDraggable(true);
    addElements();


    //f.setScrollable(false);
    f.setScrollVisible(true);
    f.addComponent(c);
    f.show();

}

public void pauseApp() {
}

public void destroyApp(boolean unconditional) {
}

public void addElements()
{
    for(int i=0;i<ROWS;i++)
    {
        for(int j=0;j<COLUMNS;j++)
        {
            b[i][j]=new Button(i+" sdkljf "+j);
            c.addComponent(b[i][j]);
            b[i][j].addActionListener(this);
        }
    }

}


/**
 * 
 * @param message message to be displayed
 * @param title title of the alert
 */
 public void showMsg(String message, String title)
{
    final Dialog d=new Dialog(title);
    d.setLayout(new GridLayout(1, 1));
    Button b=new Button("Ok");
    TextArea msg=new TextArea(message);
    msg.setUIID(message);
    msg.setEditable(false);

    //dialogContainer.addComponent(msg);
    //dialogContainer.addComponent(b);

    d.addComponent(msg);
    d.addComponent(b);

    b.addActionListener(new ActionListener() {

        public void actionPerformed(ActionEvent evt) {
             d.dispose();
        }
    });

    d.show();
}

public void actionPerformed(ActionEvent evt) {

    for(int i=0;i<ROWS;i++)
    {
        for(int j=0;j<COLUMNS;j++)
        {
            if(b[i][j]==evt.getComponent())
            {
                showMsg(i+","+j, "sl;dkf;");
            }
        }
    }

}

}