import java.awt.BorderLayout;
    import java.awt.EventQueue;
    import java.awt.List;
    import java.awt.event.ActionEvent;
    import java.awt.event.ActionListener;

    import javax.swing.JFrame;
    import javax.swing.JPanel;
    import javax.swing.border.EmptyBorder;

    public class TestFrame extends JFrame {

        private JPanel contentPane;

        public static void main(String[] args) {
            EventQueue.invokeLater(new Runnable() {
                public void run() {
                    try {
                        TestFrame frame = new TestFrame();
                        frame.setVisible(true);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }

        public TestFrame() {
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setBounds(100, 100, 450, 300);
            contentPane = new JPanel();
            contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
            contentPane.setLayout(new BorderLayout(0, 0));

            List list = new List();
            list.add("user1", 0);
            list.add("user2", 1);
            list.add("user3", 2);
            list.add("user4", 3);
            list.add("user5", 4);
            list.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(list.getSelectedItem().equals("user1")){
                        System.out.println("User 1 has been selected!");
                    }else if(list.getSelectedItem().equals("user2")){
                        System.out.println("User 2 has been selected!");
                    }
                }           
            });

            contentPane.add(list);      
            setContentPane(contentPane);
        }

    }