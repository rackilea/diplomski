public class TestFrame {

    public static void main(String... args) {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        for (int i = 0; i < 10; i++) {
            panel.add(new JButton("Hello-" + i));
        }

        MyCustomPane scrollPane = new MyCustomPane(panel); //changed this line

        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        JPanel contentPane = new JPanel(new BorderLayout());

        JPanel contentPaneSub = new JPanel();
        contentPaneSub.add(scrollPane);

        scrollPane.setOuterContainer(contentPaneSub); //added this line

        contentPane.add(contentPaneSub, BorderLayout.NORTH);

        JPanel centerPanel = new JPanel(new FlowLayout());
        centerPanel.add(new JButton("Example"));
        contentPane.add(centerPanel, BorderLayout.CENTER);

        JScrollPane scrollPane1 = new JScrollPane(contentPane);
        scrollPane1.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);

        frame.setContentPane(scrollPane1);
        //for demo purpose we set this using hard coded way
        //in real life project the java will auto adjust it size based on windows resolution
        frame.setSize(new Dimension(500, 160));
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
    }
}