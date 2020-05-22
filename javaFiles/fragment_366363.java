public class MyPanel extends JPanel {
    public MyPanel(final TestFrame frame) {
        JButton b = new JButton("Play");
        add(b);
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Container pane = frame.getContentPane();
                pane.remove(MyPanel.this);
                JPanel otherPanel = new JPanel();
                otherPanel.add(new JLabel("OtherPanel"));
                pane.add(otherPanel);
                pane.revalidate();
            }
        });
    }
}