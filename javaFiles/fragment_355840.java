import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import net.miginfocom.swing.MigLayout;

@SuppressWarnings("serial")
public class CreateTextbox extends JFrame {

    /* Make your inner components private, it's your responsibility to manage
     * them and so you'd not get undesired interactions */
    protected JTextField stringEntry, dateEntry;
    protected JLabel stringEntryLabel, dateEntryLabel;
    protected JButton print;
    protected Action validateAction;

    public CreateTextbox() {
        super("Create Textbox"); // The title makes more sense in the constructor
        /* Never use a null layout, is a bad practice, can work for a one-shot
         * but is in no way something you can manage or expand. Also the results
         * are usually clunky. I use MigLayout, it requires expertise but when
         * you master it it's very useful. For standard ones:
         * https://docs.oracle.com/javase/tutorial/uiswing/layout/visual.html */
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new MigLayout("ins 10, gap 5", // Margin around of 10 px
                                                 // 5px between components 
                "[][grow]", // Fist column, minimum; second column, grow
                "[][][]"));

        /* "this." is not necessary but it's good to realize we're talking about
         * the variable of this INSTANCE of the class */
        this.stringEntryLabel = new JLabel("Name:");
        add(this.stringEntryLabel, ""); // This string is the constraint for telling
                                   // MigLayout how to place this component,
                                   // nothing required in this case 

        this.stringEntry = new JTextField();
        add(this.stringEntry, "grow, wrap"); // Fill space, next line

        this.dateEntryLabel = new JLabel("Date:");
        add(this.dateEntryLabel, "");

        this.dateEntry = new JTextField();
        add(this.dateEntry, "grow, wrap");

        this.validateAction = new MyAction();

        this.print = new JButton(this.validateAction); // Button for the action
        add(this.print, "span 2, center"); // Use 2 cells, center the button

        /* Example of how it's useful to have an action, not just a listener */
        getRootPane().getActionMap().put("validate", this.validateAction);
    }

    /* Added originally for didactical purposes */
    @Deprecated
    public String getNameText() {
        return this.stringEntry.getText();
    }

    /* Added originally for didactical purposes */
    @Deprecated
    public String getDateText() {
        return this.dateEntry.getText();
    }

    public static void main(String... args) {
        CreateTextbox me = new CreateTextbox();
        me.pack(); // Since now you have a layout, let it do its thing
        me.setLocationByPlatform(true); // Let OS place the window
        me.setVisible(true);
    }


    /* MyAction is better an Action than an ActionListener to it can be used for
     * more purposes */
    public class MyAction extends AbstractAction {

        public MyAction() {
            super("Validate");
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            String strInput = CreateTextbox.this.stringEntry.getText();
            String strDate = CreateTextbox.this.dateEntry.getText();
            valiDate(strDate);
        }

        public void valiDate(String date) {
            // TODO code to validate the date
            System.out.println("Validating date \"" + date + "\"...");
        }

    }

}