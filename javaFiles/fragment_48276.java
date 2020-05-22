import java.awt.*;
import java.awt.event.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
class SimpleTableExample extends JFrame
{
    private JPanel      topPanel;
    private JTable      table;
    private JScrollPane scrollPane;
    private DefaultTableModel model = null;
    private JPanel pMainMenu = null;
    public SimpleTableExample()
    {

    pMainMenu = new JPanel();
    BorderLayout thisLayout = new BorderLayout();
    pMainMenu.setLayout(thisLayout);
    {
        JPanel pButtons = new JPanel();
        pMainMenu.add(pButtons, BorderLayout.NORTH);

        GridBagLayout pButtonsLayout = new GridBagLayout();
        pButtonsLayout.columnWidths = new int[]{7, 7, 7};
        pButtonsLayout.rowHeights = new int[]{25};
        pButtonsLayout.columnWeights = new double[]{0.1, 0.1, 0.1};
        pButtonsLayout.rowWeights = new double[]{0.1};
        {
            JButton btNew = new JButton();
            pButtons.add(btNew, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.NONE,
                    new Insets(0, 5, 0, 0), 0, 0));
            btNew.setText("<html><center>Run</center><center>Configuration</center></html>");
            btNew.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    btRunConfiguration(evt);
                }
            });
        }
    }




    topPanel = new JPanel();
    topPanel.setLayout( new BorderLayout() );
    {
        model = new DefaultTableModel();
        table = new JTable(model);
        scrollPane = new JScrollPane( table );
        topPanel.add( scrollPane, BorderLayout.CENTER );
        model.addColumn(" ");
        model.addColumn(" ");
        model.addColumn(" ");
    }

    getContentPane().add(pMainMenu);
    getContentPane().repaint();
    pack();
    setSize(520, 130);
    setLocationRelativeTo(null);
    setVisible(true);


}

private void btRunConfiguration(ActionEvent evt) {
    getContentPane().removeAll();
    getContentPane().add( topPanel );
    getContentPane().repaint();

    setTitle("Simple Table Application");
    setSize(300, 100);
    setBackground(Color.gray);
    pack();
    setVisible(true);

    String columnNames[] = { "Column 1", "Column 2", "Column 3" };

    new MyWorker(model).execute();
}
class MyWorker extends SwingWorker<Void, Void> {
    DefaultTableModel model;
    MyWorker(DefaultTableModel model){
        this.model=model;
    }
    @Override
       public Void doInBackground() {
        for(int i=0;i<300;i++)
        {
            try {
                Thread.sleep(1000);
            } catch(InterruptedException ie) {
                // ignore!
                ie.printStackTrace();
            }
            model.addRow(new Object[]{i,i,i});
            /**************This message dialog box show row updated to refresh table for viewing***********/
            //Must schedule the close before the dialog becomes visible
            JFrame closeDialog = new JFrame();
            final JDialog dialog = new JDialog(closeDialog, "Updated", true);

             ActionListener timerAction = new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent ae)
                {
                    dialog.setVisible(false); //should be invoked on the EDT
                    dialog.dispose();
                }
            };
            Timer timer = new Timer(500, timerAction);
            timer.start();
            dialog.setVisible(true); // if modal, application will pause here

            //System.out.println("Dialog closed");
            /**************This message dialog box show row updated to refresh table for viewing***********/

        }
          return null;
       }

       @Override
       protected void done() {

       }
   }


public static void main( String args[] )
{
    // Create an instance of the test application
    SimpleTableExample mainFrame    = new SimpleTableExample();
    mainFrame.setVisible( true );
}}