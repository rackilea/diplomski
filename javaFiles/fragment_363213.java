import java.awt.Dimension;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.EventListenerList;
import javax.swing.text.DefaultCaret;

public class ConsoleFrame {

//Objects for Console Frame
    JFrame frame = new JFrame();
    JTextArea output = new JTextArea();
    JTextField input = new JTextField();
    BoxLayout boxLayout = new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS);
    JScrollPane scrollPane = new JScrollPane(output);
    DefaultCaret caret = (DefaultCaret) output.getCaret();
    Action action = new AbstractAction() {
        @Override
        public void actionPerformed(ActionEvent e) {

            fireInputChanged(input.getText());
            input.selectAll();

        }
    };

    private EventListenerList listenerList = new EventListenerList();

    ConsoleFrame() {
        input.addActionListener(action);
        caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
        frame.setLayout(boxLayout);
        frame.add(scrollPane);
        frame.add(input);
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 250);
        frame.setLocationRelativeTo(null);
        input.setMaximumSize(new Dimension(Integer.MAX_VALUE, 10));
        output.setEditable(false);
        output.setAutoscrolls(true);
    }

    public String getInput() {
        return input.getText();
    }

    public void addInputObsever(InputObsever obsever) {
        listenerList.add(InputObsever.class, obsever);
    }

    public void removeInputObsever(InputObsever obsever) {
        listenerList.remove(InputObsever.class, obsever);
    }

    protected void fireInputChanged(String text) {

        InputObsever[] listeners = listenerList.getListeners(InputObsever.class);
        if (listeners.length > 0) {

            InputEvent evt = new InputEvent(this, text);
            for (InputObsever obsever : listeners) {
                obsever.inputChanged(evt);
            }

        }

    }

}