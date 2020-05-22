import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.util.ArrayList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class ErrorMessageW {

    private JFrame errorMessageW;
    private ArrayList<String> errors;
    private JPanel panel;
    private JScrollPane scrollPane;
    private JTextArea errorMessage = new JTextArea(3, 30);

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        final ArrayList<String> err = new ArrayList<String>();
        err.add("Short String");
        err.add("A very very very very very very very very very very very "
                + "very very very very very very very very very very very "
                + "very very very very very very very very long String");
        EventQueue.invokeLater(new Runnable() {

            public void run() {
                try {
                    ErrorMessageW window = new ErrorMessageW(err);
                    window.errorMessageW.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public ErrorMessageW(ArrayList<String> err) {
        errors = err;
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        errorMessageW = new JFrame();
        JPanel contentPane = new JPanel(new BorderLayout(5, 15));
        contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
        errorMessage.setLineWrap(true);
        errorMessage.setWrapStyleWord(true);
        JScrollPane jsp = new JScrollPane(
                errorMessage,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER
                );
        contentPane.add(jsp, BorderLayout.PAGE_START);

        errorMessageW.add(contentPane);
        errorMessageW.setTitle("Unfilled forms");
        errorMessageW.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JButton btnOk = new JButton("OK");
        btnOk.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent arg0) {
                errorMessageW.dispose();
            }
        });
        JPanel btnConstrain = new JPanel(new FlowLayout(FlowLayout.TRAILING));
        btnConstrain.add(btnOk);
        contentPane.add(btnConstrain, BorderLayout.PAGE_END);

        scrollPane = new JScrollPane();
        scrollPane.setVerticalScrollBarPolicy(
                ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        contentPane.add(scrollPane, BorderLayout.CENTER);

        DefaultListModel<String> listModel = new DefaultListModel<String>();
        for (String s : errors) {
            listModel.addElement(s);
        }
        final JList<String> errorList = new JList<String>(listModel);
        Dimension preferredSize = new Dimension(errorMessage.getPreferredSize().width,200);
        errorList.setPreferredSize(preferredSize);
        ListSelectionListener errorSelect = new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent e) {
                errorMessage.setText(errorList.getSelectedValue());
            }
        };
        errorList.addListSelectionListener(errorSelect);
        scrollPane.setViewportView(errorList);
        errorMessageW.pack();
    }

    public JFrame getErrorMessageW() {
        return errorMessageW;
    }

    public void setErrorMessageW(JFrame errorMessageW) {
        this.errorMessageW = errorMessageW;
    }
}