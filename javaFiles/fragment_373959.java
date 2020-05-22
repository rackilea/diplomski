public class JMainView extends JFrame {
    private JPanel mypanel = new JPanel(new GridLayout(0, 1, 30, 50));
    private JScrollPane scrollPane = new JScrollPane(mypanel);
    public JMainView() {
        super("Simple Example");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = this.getContentPane();
        container.setLayout(new FlowLayout());
        container.add(scrollPane);

        scrollPane.setVisible(true);
        scrollPane.setAutoscrolls(true);
        scrollPane.setPreferredSize(new Dimension(300, 400)); //========== this was missed

        mypanel.add(new JInfoView());
        mypanel.add(new JInfoView());
        mypanel.add(new JInfoView());
        mypanel.add(new JInfoView());
        mypanel.add(new JInfoView());
        mypanel.add(new JInfoView());
        mypanel.add(new JInfoView());
        mypanel.add(new JInfoView());
        mypanel.add(new JInfoView());
        this.pack();
    }

    public static void main(String[] args) {
        JMainView app = new JMainView();
        app.setVisible(true);
    }
}