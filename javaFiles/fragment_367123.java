public class JListDemo extends JFrame {

private JPanel contentPane;

/**
 * Launch the application.
 */
public static void main(String[] args) {
EventQueue.invokeLater(new Runnable() {
    public void run() {
    try {
        JListDemo frame = new JListDemo();
        frame.setVisible(true);
    } catch (Exception e) {
        e.printStackTrace();
    }
    }
});
}


public JListDemo() {
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setBounds(100, 100, 150, 303);
contentPane = new JPanel();
contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
contentPane.setLayout(new BorderLayout(0, 0));
setContentPane(contentPane);

JList list = new JList();
list.setBorder(new TitledBorder(null, "JList Demo", TitledBorder.LEADING, TitledBorder.TOP, null, null));
list.setModel(new AbstractListModel() {
    String[] values = new String[] { "Google", "Yahoo", "Facebook ",
        "EBay" };

    public int getSize() {
    return values.length;
    }

    public Object getElementAt(int index) {
    return values[index];
    }
});
contentPane.add(list, BorderLayout.CENTER);
}