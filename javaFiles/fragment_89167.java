import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public final class Date_Time extends JFrame{

    private static final long serialVersionUID = 1L;
    private JPanel show_date_time = new JPanel();
    private JLabel time = new JLabel("Time:");
    private JLabel show_time = new JLabel("Show Time");

    private DateFormat dateFormat2 = 
                new SimpleDateFormat("h:mm:ss a");
    private JButton button1 = new JButton("USELESS");           
    private java.util.Date date2;
    private JLabel label;
    private JPanel panel;

    public Date_Time(){        

        //this.setResizable(false);
        getContentPane().add(show_Time_date());
    }    

    public JPanel show_Time_date(){

        getShow_date_time().setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
        /*
         * Always set this Opaque property of the 
         * said JComponent to true, before
         * you change the Background Colour
         * of the said component in question.
         * In some Look And Feels it's set to
         * false by default, so you won't
         * see any colour, in such situations.
         */
        getShow_date_time().setOpaque(true);
        getShow_date_time().setBackground(Color.ORANGE);        

        Font f;
        f = new Font("SansSerif", Font.PLAIN, 15);

        getTime().setFont(f);
        getShow_date_time().add(getTime());
        setShow_time(new JLabel(""));

        updateDateTime();

        getShow_time().setFont(f);
        getShow_date_time().add(getShow_time());
        getShow_date_time().add(button1);

        return getShow_date_time();
    }

    public static void main(String[] args) {

        /*
         * Calls like pack()/setSize()/setVisible()
         * must be done from inside the Event Dispatch Thread
         * or the EDT in short. And not from your
         * Main Thread. Please read Concurrency in Swing
         * in detail from this link : 
         * http://docs.oracle.com/javase/tutorial/uiswing/concurrency/index.html
         */
        SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                Date_Time main_win=new Date_Time();
                main_win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                main_win.setSize(250, 75);
                main_win.setVisible(true);
            }
        });        
    }

    public void updateDateTime()
    {
        Thread th = new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                while(true)
                {
                    date2 = new java.util.Date();
                    final String dateTime = dateFormat2.format(date2);
                    /*
                     * Any updates to the GUI, must also be done
                     * on the EDT - Event Dispatch Thread.
                     */
                    SwingUtilities.invokeLater(new Runnable()
                    {
                        public void run()
                        {
                            getShow_time().setText(dateTime);
                        }
                    });                    
                }
            }
        });
        th.start();
    }

    /**
     * @return the show_time
     */
    public JLabel getShow_time() {

        return show_time;
    }

    /**
     * @param show_time the show_time to set
     */
    public void setShow_time(JLabel show_time) {
        this.show_time = show_time;
    }

    /**
     * @return the time
     */
    public JLabel getTime() {
        return time;
    }

    /**
     * @param time the time to set
     */
    public void setTime(JLabel time) {
        this.time = time;
    }

    /**
     * @return the show_date_time
     */
    public JPanel getShow_date_time() {
        return show_date_time;
    }

    /**
     * @param show_date_time the show_date_time to set
     */
    public void setShow_date_time(JPanel show_date_time) {
        this.show_date_time = show_date_time;
    }

    /**
     * @return the label1
     */


    /**
     * @param label1 the label1 to set
     */


    /**
     * @return the label
     */
    public JLabel getLabel() {

        return label;
    }

    /**
     * @param label the label to set
     */
    public void setLabel(JLabel label) {
        this.label = label;
    }

    /**
     * @return the panel
     */
    public JPanel getPanel() {
        return panel;
    }

    /**
     * @param panel the panel to set
     */
    public void setPanel(JPanel panel) {
        this.panel = panel;
    }
}